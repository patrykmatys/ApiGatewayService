package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.UserRegistrationRequest;
import org.thesis.services.user.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        return userService.registerNewUser(registrationRequest);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody UserRegistrationRequest registrationRequest) {
        ResponseEntity<String> response;
        try {
            response = userService.authenticateUser(registrationRequest);
        } catch (Exception ex) {
            response = ResponseEntity.status(403).body("User not authenticated");
        }

        return response;
    }
}
