package com.deoudegracht.deoudegracht.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// This class is used to configure the CORS policy for the application.
// The CORS policy is used to allow the application to make requests to other domains.
//and let the frontend make requests to the backend. because the backend has a different domain than the frontend.
//usually the frontend is hosted on localhost:3000 and the backend is hosted on localhost:8080.
// The addCorsMappings method is used to configure the allowed origins and methods for the application.
// The allowedOrigins method is used to specify the domains that are allowed to make requests to the application.

@Configuration
public class GlobalCorsConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(@NotNull CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost:5173")
                            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                            .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
                }
            };
        }
    }
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(@NotNull CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
//            }
//        };
//    }
