package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class NotificationsResource {

    private final PatientRepository patientRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationsResource(PatientRepository patientRepository, NotificationRepository notificationRepository) {
        this.patientRepository = patientRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("notifications")
    public ResponseEntity fetch(@RequestParam("patientId") long patientId) {
        Optional<Patient> optionalUser = this.patientRepository.findById(patientId);
        if (optionalUser.isPresent()) {
            List<NotificationCategory> categories = new ArrayList<>();
            Profile profile = optionalUser.get().getProfile();
            if (profile != null) {
                if (profile.isSmoker()) {
                    categories.add(NotificationCategory.SMOKING);
                }
            }
            List<Notification> notifications = notificationRepository.findByCategoryIn(categories);
            Collections.shuffle(notifications);
            return ResponseEntity.ok(notifications.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
