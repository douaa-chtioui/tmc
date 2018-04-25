package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientsResource {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientsResource(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/patients")
    public ResponseEntity createPatient(@RequestBody Patient patient) {
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            return ResponseEntity.status(409).build();
        } else {
            this.patientRepository.save(patient);
            return ResponseEntity.ok().build();
        }

    }

}
