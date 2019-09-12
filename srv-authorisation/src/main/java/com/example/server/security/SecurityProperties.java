package com.example.server.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("security")
public class SecurityProperties {

    @Value("${demo.oauth.jwt.public-key}")
    private String publicKey;
    @Value("${demo.oauth.jwt.private-key}")
    private String privateKey;
}
