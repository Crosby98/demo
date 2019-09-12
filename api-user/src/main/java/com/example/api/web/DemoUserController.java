package com.example.api.web;

import com.example.api.web.Service.UserService;
import com.example.api.web.bom.LoginUser;
import com.example.api.web.bom.User;
import com.example.api.web.exception.UserNotFoundException;
import com.example.bom.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoUserController {

    private final UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@RequestBody LoginUser user) throws Exception {
        String token = userService.loginUser(user);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @RequestMapping(value = "/{phone}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByPhone(@PathVariable String phone) throws UserNotFoundException {
        User user = userService.getUserByPhone(phone);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> saveImageForUser(@RequestBody Image image, Authentication authentication) {
        userService.saveImageForUser(image, ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
