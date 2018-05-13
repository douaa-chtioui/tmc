package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.ChronicDisease;
import org.ensi.tmc.domain.Patient;
import org.ensi.tmc.domain.PatientRepository;
import org.ensi.tmc.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ChronicDiseasesResource {

    private final PatientRepository patientRepository;

    @Autowired
    public ChronicDiseasesResource(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PutMapping("/patients/{patientId}/chronic-disease")
    public ResponseEntity update(@PathVariable long patientId, @RequestBody ChronicDisease chronicDisease) {
        Optional<Patient> optionalUser = patientRepository.findById(patientId);
        if (optionalUser.isPresent()) {
            Patient user = optionalUser.get();
            user.setChronicDisease(chronicDisease);
            this.patientRepository.save(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
