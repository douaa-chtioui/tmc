package org.ensi.tmc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Checkup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Patient patient;

    private Date checkupDate;

    private String patientComment;

    private String doctorComment;

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(Date checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String getPatientComment() {
        return patientComment;
    }

    public void setPatientComment(String userComment) {
        this.patientComment = userComment;
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment;
    }
}
