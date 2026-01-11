package com.example.syntac_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        //1.Define the Rules
        .authorizeHttpRequests(auth-> auth.requestMatchers("/languages").permitAll().anyRequest().authenticated()
    )//2. Enable Deafault Login Form
    .formLogin(withDefaults())
//3.Disable CSRF for testing purpose
    .csrf(csrf-> csrf.disable());
        return http.build();
    }
}
