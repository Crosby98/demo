package com.example.api.web.bom;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String surName;
    private String password;
    private String phone;
    private String email;
    private String status;
}
