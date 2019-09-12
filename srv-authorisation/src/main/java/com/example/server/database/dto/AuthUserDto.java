package com.example.server.database.dto;


import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Immutable
@Table(name = "auth_user", schema = "demo_user")
@Data
public class AuthUserDto {
    @Id
    @Column(name = "PHONE", nullable = false)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Transient
    private Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
}
