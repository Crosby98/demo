package com.example.api.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "demo_user")
@Data
public class UserDto {

    private static final long serialVersionUID = -4220669447462881674L;
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @SequenceGenerator(name = "seq_user", sequenceName = "SEQ_USER", schema = "demo_user", initialValue = 1, allocationSize = 1)
    private long id;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "SUR_NAME", nullable = false)
    private String surName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "PHONE", nullable = false)
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "STATUS")
    private String status;
}
