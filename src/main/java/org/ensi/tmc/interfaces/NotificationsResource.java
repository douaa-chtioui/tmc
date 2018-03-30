package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class NotificationsResource {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationsResource(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("notifications/{userId}")
    public ResponseEntity fetch(@PathVariable long userId) {

        Optional<User> optionalUser = this.userRepository.findById(userId);
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
