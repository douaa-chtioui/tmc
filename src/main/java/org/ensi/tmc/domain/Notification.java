package org.ensi.tmc.domain;


public class Notification {

    private String text;

    public Notification() {
    }

    public Notification(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
