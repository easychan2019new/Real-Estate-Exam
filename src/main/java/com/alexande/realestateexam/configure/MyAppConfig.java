package com.alexande.realestateexam.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry cors) {

        // set up CORS mapping
        cors.addMapping("/**").allowedOrigins("*");
    }
}
