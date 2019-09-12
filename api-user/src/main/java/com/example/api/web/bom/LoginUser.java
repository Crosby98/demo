package com.example.api.web.bom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {
    private String password;
    private String username;
    private String grant_type;

    public String toRequestParam() {
        return "grant_type="+ getGrant_type() + "&username=" + getUsername() + "&password=" + getPassword();
    }
}
