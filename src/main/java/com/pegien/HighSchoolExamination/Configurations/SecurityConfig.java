package com.pegien.HighSchoolExamination.Configurations;

import com.pegien.HighSchoolExamination.Auth.JWTTOkenFilter;
import com.pegien.HighSchoolExamination.Auth.UserDetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static String jwtSecretKey="PatrickGeePatrickGeePatrickGeePatrickGeePatrickGeePatrickGeePatrickGeeSchoolExamsApp";

    @Autowired
    private JWTTOkenFilter jwtTokenFilter;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http
                .cors().
                and()

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**",
                        "/v3/api-docs/**"
                        ,"/api/v1/user/registerUser"
                        ,"/api/v1/user/allRoles"
                        ,"/api/v1/user/passwordReset"
                        ,"/api/v1/user/smsForgotPassword"
                        ,"/api/v1/user/emailForgotPassword"
                        ,"/api/v1/user/login"

                )
                .permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


                http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }



    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(myUserDetailsService);
    }



}
