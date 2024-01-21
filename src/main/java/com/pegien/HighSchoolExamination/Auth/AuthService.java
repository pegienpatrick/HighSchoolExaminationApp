package com.pegien.HighSchoolExamination.Auth;


import com.pegien.HighSchoolExamination.Auth.AuthToken.Token;
import com.pegien.HighSchoolExamination.Auth.AuthToken.TokenRepository;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetails;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetailsService;
import com.pegien.HighSchoolExamination.Users.User;
import com.pegien.HighSchoolExamination.Users.UserRepository;
import com.pegien.HighSchoolExamination.Utils.ConvertionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private TokenRepository tokenRepository;


    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;



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



}
