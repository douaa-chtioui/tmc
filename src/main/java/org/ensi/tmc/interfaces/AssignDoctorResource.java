package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.Doctor;
import org.ensi.tmc.domain.DoctorRepository;
import org.ensi.tmc.domain.Patient;
import org.ensi.tmc.domain.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AssignDoctorResource {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AssignDoctorResource(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @PutMapping("/patients/{patientId}/doctor")
    public ResponseEntity assignDoctor(@PathVariable long patientId, @RequestBody Assignment assignment) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        Optional<Doctor> optionalDoctor = doctorRepository.findByCode(assignment.doctorCode);
        if (optionalPatient.isPresent() && optionalDoctor.isPresent()) {
            Patient user = optionalPatient.get();
            user.setDoctor(optionalDoctor.get());
            this.patientRepository.save(user);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private static class Assignment {
        public String doctorCode;
    }

}
