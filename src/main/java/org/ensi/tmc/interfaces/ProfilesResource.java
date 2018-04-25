package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProfilesResource {

    private final PatientRepository patientRepository;

    @Autowired
    public ProfilesResource(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PutMapping("/patients/{patientId}/profile")
    public ResponseEntity update(@PathVariable long patientId, @RequestBody Profile profile) {
        Optional<Patient> optionalUser = patientRepository.findById(patientId);
        if (optionalUser.isPresent()) {
            Patient user = optionalUser.get();
            user.setProfile(profile);
            this.patientRepository.save(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
