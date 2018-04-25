package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.Patient;
import org.ensi.tmc.domain.Profile;
import org.ensi.tmc.domain.User;
import org.ensi.tmc.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    private static UserView toUserView(User user) {
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
    }


}
