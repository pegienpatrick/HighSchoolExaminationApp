package com.pegien.HighSchoolExamination.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
}
