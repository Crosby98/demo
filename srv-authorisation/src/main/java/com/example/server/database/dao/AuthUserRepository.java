package com.example.server.database.dao;

import com.example.server.database.dto.AuthUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserDto, String> {
    AuthUserDto findUserByUserName(String name);
}
