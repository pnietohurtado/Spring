package com.websocket.demo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer

{

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // Grant permission from any URL
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Origin" , "Content-Type", "Accept", "Authorization")
                .allowCredentials(true)
                .maxAge(3600);

    }

}
