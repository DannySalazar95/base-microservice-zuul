package com.dannysn.school_system_zuul.eureka;


import com.dannysn.school_system_zuul.models.Jwt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "service-authorization",
    configuration = AuthorizationServiceRestInterceptor.class
)
public interface AuthorizationServiceRest {

    @GetMapping(value = "/v1/jwt-encode", consumes = "application/json")
    Jwt jwtEncode();

}
