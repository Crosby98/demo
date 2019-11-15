package com.example.api.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithTestOauth2Authentication> {

    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @Override
    public SecurityContext createSecurityContext(WithTestOauth2Authentication customUser) {
        SecurityContext testSecurityContext = SecurityContextHolder.createEmptyContext();

        Set<String> scopes = new HashSet<>();
        Collections.addAll(scopes, "read", "write");

        OAuth2Request oAuth2Request = new OAuth2Request(null, "clientId",
                null, true, scopes, null, null,
                null, null);

        TestingAuthenticationToken authenticationToken = new TestingAuthenticationToken(customUser.username(), customUser.password(), customUser.authority());

        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authenticationToken);

        // overriding jwt token store, because it don't have storeAccessToken() implementation
        defaultTokenServices.setTokenStore(new InMemoryTokenStore());

        OAuth2AccessToken token = defaultTokenServices.createAccessToken(oAuth2Authentication);

        // setting token to details, to retrieve it in testing class
        oAuth2Authentication.setDetails(token);

        testSecurityContext.setAuthentication(oAuth2Authentication);

        return testSecurityContext;
    }
}
