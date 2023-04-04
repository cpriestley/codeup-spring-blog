package com.code.codeupspringblog.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
            .and()
            .logout()
                .logoutSuccessUrl("/") // append a query string value
            .and()
            .authorizeHttpRequests(request -> request
                .requestMatchers("/hello", "/hello/{name}", "/posts/create", "/posts/{id}/edit", "/posts/{id}/delete", "/users/{id}/delete")
                .authenticated()
                .requestMatchers("/", "/test", "/css/**", "/img/**", "/js/**",
                        "/sign-up", "/posts", "/posts/{id}", "/join", "/roll-dice", "/roll-dice/{guess}")
                .permitAll()
            );
        return http.build();
    }

}
