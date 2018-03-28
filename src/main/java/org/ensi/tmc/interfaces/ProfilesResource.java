package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.Profile;
import org.ensi.tmc.domain.User;
import org.ensi.tmc.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProfilesResource {

    private final UserRepository userRepository;

    @Autowired
    public ProfilesResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PutMapping("/users/{userId}/profile")
    public ResponseEntity update(@PathVariable long userId, @RequestBody Profile profile) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setProfile(profile);
            this.userRepository.save(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void updateUserProfile(User user, Profile updated) {
        if (user.getProfile() != null) {
            user.getProfile().setGender(updated.getGender());
            user.getProfile().setSmocker(updated.isSmoker());
            user.getProfile().setDiabetic(updated.isDiabetic());
            user.getProfile().setDyslipidemic(updated.isDyslipidemic());
            user.getProfile().setHypertensive(updated.isHypertensive());
            user.getProfile().setFamilyAntecedent(updated.isFamilyAntecedent());
            user.getProfile().setPersonalAntecedent(updated.isPersonalAntecedent());
            user.getProfile().setMenopause(updated.isMenopause());
            user.getProfile().setHeight(updated.getHeight());
            user.getProfile().setWeight(updated.getWeight());
        } else {
            user.setProfile(updated);
        }
    }
}
