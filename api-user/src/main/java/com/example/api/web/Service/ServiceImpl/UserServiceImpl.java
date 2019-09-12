package com.example.api.web.Service.ServiceImpl;

import com.example.api.dto.UserDto;
import com.example.api.dto.dao.UserRepository;
import com.example.api.web.Service.UserService;
import com.example.api.web.bom.LoginUser;
import com.example.api.web.bom.User;
import com.example.api.web.converter.UserConverter;
import com.example.api.web.exception.UserNotFoundException;
import com.example.api.web.сlient.AuthServiceClient;
import com.example.api.web.сlient.ImagesServiceClient;
import com.example.bom.Image;
import com.example.bom.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService implements UserService {

    @Value("${demo.user.oauth.clientId}")
    private String CLIENT_ID;

    @Value("${demo.user.oauth.clientSecret}")
    private String CLIENT_SECRET;

    private final UserRepository userRepository;

    private final ImagesServiceClient imagesServiceClient;

    private final AuthServiceClient authServiceClient;

    private final PasswordEncoder passwordEncoder;

    private final UserConverter userConverter;

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userConverter.toDto(user));
    }

    @Override
    public String loginUser(LoginUser user) throws Exception {
        String authHeader = generateBasicAuthHeader(CLIENT_ID, CLIENT_SECRET);
        return authServiceClient.loginUser(user.getGrant_type(), user.getUsername(), user.getPassword(), authHeader);
    }

    @Override
    public User getUserByPhone(String phone) throws UserNotFoundException {
        UserDto userDto = userRepository.findByPhone(phone);
        if (userDto == null) {
            throw new UserNotFoundException("User not found");
        }
        return userConverter.fromDto(userDto);
    }

    @Override
    public void saveImageForUser(Image image, String token) {
        imagesServiceClient.addNewImage(image, generateBearerAuthHeader(token));
    }

    @Override
    public List<User> getUsers() {
        List<UserDto> userDtos = userRepository.findAll();
        return userDtos.stream().map(userConverter::fromDto).collect(Collectors.toList());
    }
}
