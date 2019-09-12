package com.example.api.web.converter;

import com.example.api.dto.UserDto;
import com.example.api.web.bom.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromDto(UserDto source) {
        User destination = new User();
        destination.setPhone(source.getPhone());
        destination.setEmail(source.getEmail());
        destination.setFirstName(source.getFirstName());
        destination.setSurName(source.getSurName());
        destination.setStatus(source.getStatus());
        return destination;
    }

    public UserDto toDto(User source) {
        UserDto destination = new UserDto();
        destination.setPhone(source.getPhone());
        destination.setEmail(source.getEmail());
        destination.setFirstName(source.getFirstName());
        destination.setSurName(source.getSurName());
        destination.setStatus(source.getStatus());
        destination.setPassword(source.getPassword());
        return destination;
    }
}
