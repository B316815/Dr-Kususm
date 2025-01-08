package com.Doctors.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf().disable().cors().disable();
        http.authorizeHttpRequests().anyRequest().permitAll();
//        http.authorizeHttpRequests().
//                requestMatchers("/api/d1/user/signup","/api/d1/user/login","/api/d1/user/verifySignIn","/api/d1/user/verify")
//                .permitAll()
//                .requestMatchers("/api/d1/addCountry","/api/d1/user/profile").hasRole("ADMIN")
//                .anyRequest().authenticated();
        return http.build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
