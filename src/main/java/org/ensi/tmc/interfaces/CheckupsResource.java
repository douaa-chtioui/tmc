package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.Checkup;
import org.ensi.tmc.domain.CheckupRepository;
import org.ensi.tmc.domain.Patient;
import org.ensi.tmc.domain.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CheckupsResource {

    private final PatientRepository patientRepository;
    private final CheckupRepository checkupRepository;

    @Autowired
    public CheckupsResource(PatientRepository patientRepository, CheckupRepository checkupRepository) {
        this.patientRepository = patientRepository;
        this.checkupRepository = checkupRepository;
    }

    @PostMapping("/patients/{patientId}/checkups")
    public ResponseEntity update(@PathVariable long patientId, @RequestBody Checkup checkup) {
        Optional<Patient> optionalUser = patientRepository.findById(patientId);
        if (optionalUser.isPresent()) {
            checkup.setUser(optionalUser.get());
            this.checkupRepository.save(checkup);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/patients/{patientId}/checkups/{checkupId}")
    public ResponseEntity update(@PathVariable long checkupId, @RequestBody Comment comment) {
        Optional<Checkup> optionalCheckup = checkupRepository.findById(checkupId);
        if (optionalCheckup.isPresent()) {
            Checkup checkup = optionalCheckup.get();
            checkup.setDoctorComment(comment.value);
            this.checkupRepository.save(checkup);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    static class Comment {
        public String value;
    }

}
