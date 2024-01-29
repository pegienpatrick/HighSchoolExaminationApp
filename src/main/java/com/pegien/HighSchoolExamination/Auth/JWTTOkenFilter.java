package com.pegien.HighSchoolExamination.Auth;

import com.pegien.HighSchoolExamination.Auth.AuthToken.Token;
import com.pegien.HighSchoolExamination.Auth.AuthToken.TokenRepository;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetails;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetailsService;
import com.pegien.HighSchoolExamination.Configurations.SecurityConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Component
public class JWTTOkenFilter extends OncePerRequestFilter {


    @Autowired
    private AuthService authService;





    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization=request.getHeader("Authorization");
        String init="Bearer ";
        if(authorization!=null&&authorization.contains(init))
        {
            try {
                String tokenString = authorization.replaceAll(init, "");
                Jws<Claims> claims = Jwts.parser().setSigningKey(SecurityConfig.jwtSecretKey).build().parseClaimsJws(tokenString);
                String username = claims.getBody().getSubject();
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    Date expiry = claims.getBody().getExpiration();
                    Date current = new Date();
                    if (current.before(expiry)) {
                        authService.authorizeRequest(tokenString, request, username);
                    }
                }
            }catch (Exception es)
            {

            }
        }
        filterChain.doFilter(request, response);
    }
}
