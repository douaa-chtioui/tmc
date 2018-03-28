package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.User;
import org.ensi.tmc.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersResource {

    private final UserRepository userRepository;

    @Autowired
    public UsersResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchUsers() {
       return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        this.userRepository.save(user);
    }
}
