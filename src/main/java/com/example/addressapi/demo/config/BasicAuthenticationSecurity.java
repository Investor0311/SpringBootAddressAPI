/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.addressapi.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

///**
// * Basic Authentication class which is for permitting urls with OPTIONS tag and authenticating token generated using login process
// * @author Yash
// */
@Configuration
@EnableWebSecurity
public class BasicAuthenticationSecurity {
    
    /**
     * @brief This function is for setting up authentication for the API.We are defining username and password which encrypted in the below function
     * @param encoder of type Password
     * @return UserDetailsService
     */
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder)
    {
        UserDetails usercredentials= User.withUsername("Yash").password(encoder.encode("abc")).roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(usercredentials);
    }
    
    /**
     * @brief This function is for encryption of password
     * @return PasswordEncoder
     */
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * @brief This function is for setting up basic configuration for url authorization.It defines which urls are protected and which are for public use.
     * @return SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register","/auth").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/home","/delete","/update")
                .authenticated().and().formLogin().and().httpBasic().and().build();
        
    }
   
    
    
}
