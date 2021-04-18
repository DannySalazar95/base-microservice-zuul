package com.dannysn.school_system_zuul.filters;


import com.dannysn.school_system_zuul.models.Jwt;
import com.dannysn.school_system_zuul.services.AuthorizationServiceFeignInterface;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import feign.FeignException;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AuthorizationServicePreFilter extends ZuulFilter {

    @Autowired
    @Qualifier("authorizationServiceFeign")
    private AuthorizationServiceFeignInterface authorizationService;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        String URI = RequestContext.getCurrentContext().getRequest().getRequestURI();
        String[] URI_exceptions = new String[] {"/authorization/v1/oauth/token","/authorization/api/v1/jwt-encode"};
        return !ArrayUtils.contains(URI_exceptions, URI);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        try{
            Jwt jwt = authorizationService.generateJwtEncode();
            context.addZuulRequestHeader("Jwt", jwt.getJwt());
        }catch (FeignException e){
            throw new ZuulException(e.getMessage(), e.status() , "GENERATE_JWT_ENCODE_EXCEPTION");
        }
        return null;
    }
}
