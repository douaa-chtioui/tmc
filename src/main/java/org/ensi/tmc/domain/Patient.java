package org.ensi.tmc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chronic_disease_id")
    private ChronicDisease chronicDisease;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    private List<Checkup> checkups;


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ChronicDisease getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(ChronicDisease chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Checkup> getCheckups() {
        if(checkups == null){
            this.checkups = new ArrayList<>();
        }
        return checkups;
    }

    public void setCheckups(List<Checkup> checkups) {
        this.checkups = checkups;
    }
}
