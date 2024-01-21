package com.pegien.HighSchoolExamination.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static String jwtSecretKey="PatrickGeePatrickGeePatrickGeePatrickGeePatrickGeePatrickGeePatrickGeeSchoolExamsApp";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http.cors().
                and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**",
                        "/v3/api-docs/**"
                        ,"/api/v1/registerUser"
                        ,"/api/v1/registerUser"
                        ,"/api/v1/registerUser"

                )
                .permitAll()
                .anyRequest().authenticated();



    }



    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }






}
