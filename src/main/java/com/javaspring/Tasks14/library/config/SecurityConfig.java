package com.javaspring.Tasks14.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        http
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/error").permitAll()
                        .requestMatchers("/authors", "/authors/**", "/books", "/books/**").permitAll()
                        .requestMatchers(
                                "/authors/create", "/authors/edit/**", "/authors/delete/**",
                                "/books/create", "/books/edit/**", "/books/delete/**"
                        ).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/?logout")
                        .permitAll()
                );
        return http.build();
    }
}