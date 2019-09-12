package com.example.api.web.сlient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-srv-authorisation")
public interface AuthServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String loginUser(@RequestParam("grant_type") String grantType, @RequestParam("username") String userName,
                     @RequestParam("password") String password , @RequestHeader("Authorization") String authHeader) throws Exception;
}
