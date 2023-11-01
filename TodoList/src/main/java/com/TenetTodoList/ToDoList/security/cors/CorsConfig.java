package com.TenetTodoList.ToDoList.security.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("")
                .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
                .allowCredentials(true);
    }
}
