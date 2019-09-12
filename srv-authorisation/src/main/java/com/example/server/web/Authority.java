package com.example.server.web;

public enum Authority {

    USER("USER");

    String value;

    Authority(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
