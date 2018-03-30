package org.ensi.tmc.domain;

import javax.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;
    private String text;
    @Enumerated(EnumType.STRING)
    private NotificationCategory category;

    public Notification() {
    }

    public Notification(String text) {
        this.text = text;
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getText() {
        return text;
    }

    public NotificationCategory getCategory() {
        return category;
    }
}
