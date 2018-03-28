package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.User;
import org.ensi.tmc.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserCredential credential) {
        Optional<User> user = userRepository.findByEmail(credential.email);
        if (user.isPresent() && user.get().getPassword().equals(credential.password)) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    static class UserCredential {
        public String email;
        public String password;
    }
}
