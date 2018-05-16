package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    private final UserRepository userRepository;
    private final CheckupRepository checkupRepository;

    @Autowired
    public LoginController(UserRepository userRepository, CheckupRepository checkupRepository) {
        this.userRepository = userRepository;
        this.checkupRepository = checkupRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchUsers() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<UserView> login(@RequestBody UserCredential credential) {
        Optional<User> user = userRepository.findByEmail(credential.email);
        if (user.isPresent() && user.get().getPassword().equals(credential.password)) {
            return ResponseEntity.ok(toUserView(user.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private static class UserCredential {
        public String email;
        public String password;
    }

    private UserView toUserView(User user) {
        UserView view = new UserView();
        view.identifier = user.getIdentifier();
        view.email = user.getEmail();
        view.firstname = user.getFirstname();
        view.lastname = user.getLastname();
        view.age = user.getAge();
        if (Patient.class.isInstance(user)) {
            Patient patient = (Patient) user;
            view.profile = patient.getProfile();
            view.hasDoctor = patient.getDoctor() != null;
            view.patient = true;
            view.checkups = patient.getCheckups().stream().map(checkup -> {
                CheckupView checkupView = new CheckupView();
                checkupView.checkupDate = checkup.getCheckupDate();
                checkupView.doctorComment = checkup.getDoctorComment();
                checkupView.patientComment = checkup.getPatientComment();
                checkupView.identifier = checkup.getIdentifier();
                return checkupView;
            }).collect(Collectors.toList());
        } else {
            view.checkups = this.checkupRepository.findByPatientDoctorIdentifier(user.getIdentifier())
                    .stream().map(checkup -> {
                        CheckupView checkupView = new CheckupView();
                        checkupView.checkupDate = checkup.getCheckupDate();
                        checkupView.doctorComment = checkup.getDoctorComment();
                        checkupView.patientComment = checkup.getPatientComment();
                        checkupView.identifier = checkup.getIdentifier();
                        checkupView.patientProfile = checkup.getPatient().getProfile();
                        return checkupView;
                    }).collect(Collectors.toList());
        }
        return view;
    }

    private static class UserView {
        public long identifier;
        public String email;
        public String firstname;
        public String lastname;
        public Integer age;
        public Profile profile;
        public boolean hasDoctor;
        public boolean patient;
        public List<CheckupView> checkups;
    }

    private static class CheckupView {
        public long identifier;

        public Profile patientProfile;

        public Date checkupDate;

        public String patientComment;

        public String doctorComment;
    }


}
