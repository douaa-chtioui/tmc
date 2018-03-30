package org.ensi.tmc.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByCategoryIn(List<NotificationCategory> categories);
}
