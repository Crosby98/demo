package com.example.api.dto.dao;

import com.example.api.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserDto, Long> {

    UserDto findByPhone(String phone);
}
