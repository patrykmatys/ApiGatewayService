package org.thesis.services.user;

import org.springframework.http.ResponseEntity;
import org.thesis.models.UserRegistrationRequest;

public interface UserService {
    ResponseEntity<String> registerNewUser(UserRegistrationRequest user);
    ResponseEntity<String> authenticateUser(UserRegistrationRequest user);
}
