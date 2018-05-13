package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.ChronicDisease;
import org.ensi.tmc.domain.User;
import org.ensi.tmc.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ChronicDiseaseResource {

    private final UserRepository userRepository;

    @Autowired
    public ChronicDiseaseResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PutMapping("/users/{userId}/chronicDisease")
    public ResponseEntity update(@PathVariable long userId, @RequestBody ChronicDisease chronicDisease) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            //user.setChronicDisease(chronicDisease);
            this.userRepository.save(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}