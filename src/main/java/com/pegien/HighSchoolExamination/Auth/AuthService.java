package com.pegien.HighSchoolExamination.Auth;


import com.pegien.HighSchoolExamination.Auth.AuthToken.Token;
import com.pegien.HighSchoolExamination.Auth.AuthToken.TokenRepository;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetails;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetailsService;
import com.pegien.HighSchoolExamination.Configurations.SecurityConfig;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
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

    @Autowired
    private AuthenticationManager authenticationManager;



    public void authorizeRequest(String tokenString, HttpServletRequest request,String username)
    {
        Optional<Token> tmpToken=tokenRepository.findByValue(tokenString);
        if(tmpToken.isPresent()) {
            Token token=tmpToken.get();
            if (token.isUsable()) {
                token.setLastAccess(new Date().getTime());
                tokenRepository.save(token);
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
            return currUser;
        }
        else{
            return null;
        }
    }


    public String loginUser(Long num, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(num,password)
        );

        String token = Jwts.builder().setClaims(new HashMap<>()).setSubject(num.toString()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, SecurityConfig.jwtSecretKey).compact();


        Token authorizationTokens=Token.builder()
                .lastAccess(new Date().getTime())
                .loggedOut(false)
                .inActiveTime(TimeUnit.MINUTES.toMillis(10))
                .value(token)
                .build();

        tokenRepository.saveAndFlush(authorizationTokens);

        String authorization="Bearer "+token;

        return authorization;
    }
}
