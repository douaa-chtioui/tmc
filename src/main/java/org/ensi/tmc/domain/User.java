package org.ensi.tmc.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;

    public User() {
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
