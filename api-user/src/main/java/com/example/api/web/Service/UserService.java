package com.example.api.web.Service;

import com.example.api.web.bom.LoginUser;
import com.example.api.web.bom.User;
import com.example.api.web.exception.UserNotFoundException;
import com.example.bom.Image;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    String loginUser(LoginUser user) throws Exception;

    User getUserByPhone(String phone) throws UserNotFoundException;

    void saveImageForUser(Image image, String token);

    List<User> getUsers();
}
