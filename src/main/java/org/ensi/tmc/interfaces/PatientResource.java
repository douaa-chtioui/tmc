package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientResource {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public PatientResource(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @PostMapping("/patients")
    public ResponseEntity createPatient(@RequestBody PatientInscription patientInscription) {
        Optional<Doctor> doctor = this.doctorRepository.findByCode(patientInscription.doctorCode);
        if (doctor.isPresent()) {
            Patient patient = patientInscription.patient;
            patient.setDoctor(doctor.get());
            this.patientRepository.save(patient);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Invalid doctor code");
        }
    }

    public static class PatientInscription {
        public Patient patient;
        public String doctorCode;
    }
}
