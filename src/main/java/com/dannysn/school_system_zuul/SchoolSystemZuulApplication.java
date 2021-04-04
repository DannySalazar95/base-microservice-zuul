package com.dannysn.school_system_zuul;

import com.dannysn.school_system_zuul.filters.AuthorizationServicePreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
public class SchoolSystemZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolSystemZuulApplication.class, args);
    }

    @Bean
    public AuthorizationServicePreFilter preAuthorizationFilter(){
        return new AuthorizationServicePreFilter();
    }

}
