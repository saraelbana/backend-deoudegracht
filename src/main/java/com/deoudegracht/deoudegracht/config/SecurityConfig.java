package com.deoudegracht.deoudegracht.config;

import com.deoudegracht.deoudegracht.security.JwtRequestFilter;
import com.deoudegracht.deoudegracht.security.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;
    public SecurityConfig(DataSource dataSource, UserDetailsService userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public JwtRequestFilter jwtRequestFilter(JwtService jwtService) {
        return new JwtRequestFilter(jwtService, userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtRequestFilter jwtRequestFilter) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()
                        .requestMatchers("/categories").permitAll()
                        .requestMatchers("/uploads/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/menu-items").permitAll()
                        .requestMatchers(HttpMethod.GET, "/employees/**").hasAnyAuthority("ADMIN", "CHEF")
                        .requestMatchers(HttpMethod.POST, "/employees/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/employees/**").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/recipes/**").hasAnyAuthority("ADMIN", "CHEF", "EMPLOYEE")
                        .requestMatchers("/recipes/**").hasAnyAuthority("ADMIN", "CHEF")
                        .requestMatchers("/menu-items/**").hasAnyAuthority("ADMIN", "CHEF")
                        .requestMatchers(HttpMethod.GET, "/guests/{username}").access((authentication, context) -> {
                            String username = context.getVariables().get("username");
                            boolean isAuthorized = authentication.get().getName().equals(username) || authentication.get().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
                            return new AuthorizationDecision(isAuthorized);
                        })
                        .requestMatchers("/guests/**").hasAuthority("ADMIN")
                        .requestMatchers("/reservations/**").authenticated()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
