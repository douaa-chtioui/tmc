package org.ensi.tmc.domain;


import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ChronicDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;

    @Enumerated(value = EnumType.STRING)
    Disease disease;

    boolean mechanicalValve;

    boolean biologicalValve;

    boolean stentsPose;

    boolean aortoCoronaryBypass;

    boolean pacemaker;

    boolean defibrillator;

    boolean tripleRoom;

    boolean ventricularFibrillation;

    public ChronicDisease() {
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public boolean isMechanicalValve() {
        return mechanicalValve;
    }

    public void setMechanicalValve(boolean mechanicalValve) {
        this.mechanicalValve = mechanicalValve;
    }

    public boolean isBiologicalValve() {
        return biologicalValve;
    }

    public void setBiologicalValve(boolean biologicalValve) {
        this.biologicalValve = biologicalValve;
    }


    public boolean isStentsPose() {
        return stentsPose;
    }

    public void setStentsPose(boolean stentsPose) {
        this.stentsPose = stentsPose;
    }


    public boolean isAortoCoronaryBypass() {
        return aortoCoronaryBypass;
    }


    public void setAortoCoronaryBypass(boolean aortoCoronaryBypass) {
        this.aortoCoronaryBypass = aortoCoronaryBypass;
    }


    public boolean isPacemaker() {
        return pacemaker;
    }

    public void setPacemaker(boolean pacemaker) {
        this.pacemaker = pacemaker;
    }


    public boolean isDefibrillator() {
        return defibrillator;
    }

    public void setDefibrillator(boolean defibrillator) {
        this.defibrillator = defibrillator;
    }


    public boolean isTripleRoom() {
        return tripleRoom;
    }


    public void setTripleRoom(boolean tripleRoom) {
        this.tripleRoom = tripleRoom;
    }


    public boolean isVentricularFibrillation() {
        return ventricularFibrillation;
    }

    public void setVentricularFibrillation(boolean ventricularFibrillation) {
        this.ventricularFibrillation = ventricularFibrillation;
    }
}
