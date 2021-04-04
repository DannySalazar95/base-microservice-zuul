package com.dannysn.school_system_zuul.services;

import com.dannysn.school_system_zuul.eureka.AuthorizationServiceRest;
import com.dannysn.school_system_zuul.models.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorizationServiceFeign")
public class AuthorizationServiceFeign implements AuthorizationServiceFeignInterface {

    private final AuthorizationServiceRest clientFeign;

    @Autowired
    public AuthorizationServiceFeign(AuthorizationServiceRest clientFeign) {
        this.clientFeign = clientFeign;
    }

    @Override
    public Jwt generateJwtEncode() {
        return clientFeign.jwtEncode();
    }
}
