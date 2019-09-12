package com.example.api.dto;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface withTestOauth2Authentication {

    String username() default "rob";

    String password() default "1234";

    String authority() default "USER";
}
