package com.example.bom.service;

import java.nio.charset.Charset;
import java.util.Base64;

public class AbstractService {

    protected String generateBasicAuthHeader(String clientId, String clientSecret) {
        String auth = clientId + ":" + clientSecret;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(encodedAuth);
    }

    protected String generateBearerAuthHeader(String token) {
        return "Bearer " + token;
    }

}
