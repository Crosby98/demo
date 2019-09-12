package com.example.server.web.service;

import com.example.server.database.dao.AuthUserRepository;
import com.example.server.database.dto.AuthUserDto;
import com.example.server.web.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AuthUserDto foundUser = authUserRepository.findUserByUserName(userName);
        if (foundUser == null) {
            throw new UsernameNotFoundException("User not found for given credentials");
        }
        Collection<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(Authority.USER.getValue()));
        foundUser.setGrantedAuthorities(role);
        return new User(foundUser.getUserName(), foundUser.getPassword(), foundUser.getGrantedAuthorities());
    }
}
