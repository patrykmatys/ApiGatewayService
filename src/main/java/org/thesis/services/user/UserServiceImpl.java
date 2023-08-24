package org.thesis.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thesis.models.UserRegistrationRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String usersServiceUrl;

    @Override
    public ResponseEntity<String> registerNewUser(UserRegistrationRequest user) {
        String url = usersServiceUrl + "/register";
        return restTemplate.postForEntity(url, user, String.class);
    }

    @Override
    public ResponseEntity<String> authenticateUser(UserRegistrationRequest user) {
        String url = usersServiceUrl + "/authenticate";
        return restTemplate.postForEntity(url, user, String.class);
    }
}
