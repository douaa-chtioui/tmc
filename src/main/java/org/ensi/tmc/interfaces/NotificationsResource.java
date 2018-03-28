package org.ensi.tmc.interfaces;

import org.ensi.tmc.domain.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsResource {

    @GetMapping("notifications/{userId}")
    public ResponseEntity<Notification> fetch(@PathVariable long userId) {
        return ResponseEntity.ok(new Notification("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eu dui convallis, consequat lacus at, porta augue. Sed lacinia tellus eget sodales aliquet. Proin ut viverra enim, eu tristique metus"));
    }

}
