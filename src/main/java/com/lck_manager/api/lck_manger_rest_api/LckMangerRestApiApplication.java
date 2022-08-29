package com.lck_manager.api.lck_manger_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LckMangerRestApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LckMangerRestApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LckMangerRestApiApplication.class, args);
    }

}
