package com.dannysn.school_system_zuul.services;

import com.dannysn.school_system_zuul.models.Jwt;

public interface AuthorizationServiceFeignInterface {

    public Jwt generateJwtEncode();

}
