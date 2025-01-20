package com.pegien.HighSchoolExamination.Auth;


import com.pegien.HighSchoolExamination.Auth.AuthToken.Token;
import com.pegien.HighSchoolExamination.Auth.AuthToken.TokenRepository;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetails;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetailsService;
import com.pegien.HighSchoolExamination.Configurations.SecurityConfig;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.Utils.UserRoleUtils;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.entity.UserRole;
import com.pegien.HighSchoolExamination.Users.UsersHelpers.UserRoles.repository.UserRolesRepository;
import com.pegien.HighSchoolExamination.Users.entity.User;
import com.pegien.HighSchoolExamination.Users.Repository.UserRepository;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class AuthService {

    @Autowired
    private TokenRepository tokenRepository;


    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRolesRepository userRolesRepository;



    public void authorizeRequest(String tokenString, HttpServletRequest request,String username)
    {
        Optional<Token> tmpToken=tokenRepository.findByValue(tokenString);
        if(tmpToken.isPresent()) {
            Token token=tmpToken.get();
            if (token.isUsable()) {
                if(!request.getRequestURL().toString().contains("/api/v1/user/checkUser")) {
                    token.setLastAccess(new Date().getTime());
                    tokenRepository.save(token);
                }
                MyUserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    }

    public User getActiveUser()
    {
        Long userId = ConvertionUtils.getLong(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            User currUser = optionalUser.get();
            currUser.setRoles(
                    UserRoleUtils.rolesMap.get(currUser.getRolesCategory())
            );

            List<UserRole> userRoles = userRolesRepository.findByUserId(currUser.getNum());
            for(UserRole r:userRoles)
                currUser.getRoles().add(r.getRoleName());
            return currUser;
        }
        else{
            return null;
        }
    }


    public String loginUser(Long num, String password,AuthenticationManager authenticationManager) {
//        System.out.println("Loggin in "+num+" - "+password);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(num,password)
        );

//        System.out.println("success Loggin in "+num+" - "+password);
        String token = Jwts.builder().setClaims(new HashMap<>()).setSubject(num.toString()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, SecurityConfig.jwtSecretKey).compact();


        Token authorizationTokens=Token.builder()
                .lastAccess(new Date().getTime())
                .loggedOut(false)
                .inActiveTime(TimeUnit.MINUTES.toMillis(10))
                .value(token)
                .userId(num)
                .build();

        tokenRepository.saveAndFlush(authorizationTokens);

        String authorization="Bearer "+token;

        return authorization;
    }


    public String logOut(HttpServletRequest request)
    {
        String authorization=request.getHeader("Authorization");
        String init="Bearer ";
        if(authorization!=null&&authorization.contains(init)) {
            String tokenString = authorization.replaceAll(init, "");
            Optional<Token> optionalAuthorizationTokens = tokenRepository.findByValue(tokenString);
            if (optionalAuthorizationTokens.isEmpty())
                throw new UnsupportedOperationException("no such authorization");

            Token authorizationTokens = optionalAuthorizationTokens.get();

            //perform the logout action
            authorizationTokens.setLoggedOut(true);
            tokenRepository.save(authorizationTokens);

            return "Success";
        }
        else
            throw new UnsupportedOperationException("no such authorization");
    }

    public String logOutAllDevices()
    {
            List<Token> allActiveUserTokens = tokenRepository.findByUserId(getActiveUser().getNum());
            for(Token authorizationTokens:allActiveUserTokens) {
                //perform the logout action
                authorizationTokens.setLoggedOut(true);
                tokenRepository.save(authorizationTokens);
            }
            return "Success";
    }


}
