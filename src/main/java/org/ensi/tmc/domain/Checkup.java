package org.ensi.tmc.domain;

import javax.persistence.*;

@Entity
public class Checkup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
