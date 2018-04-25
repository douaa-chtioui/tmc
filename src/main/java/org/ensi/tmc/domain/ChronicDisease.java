package org.ensi.tmc.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class ChronicDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identifier;
    String disease ;
    boolean mechanicalValve ;
    boolean biologicalValve;
    boolean stentsPose ;
    boolean aortoCoronaryBypass ;
    boolean pacemaker;
    boolean defibrillator ;
    boolean tripleRoom;
    boolean ventricularFibrillation;

    public ChronicDisease() { }

    public String getDisease() {
        return disease;
    }

    public boolean isMechanicalValve() {
        return mechanicalValve;
    }

    public boolean isBiologicalValve() {
        return biologicalValve;
    }

    public boolean isStentsPose() {
        return stentsPose;
    }

    public boolean isAortoCoronaryBypass() {
        return aortoCoronaryBypass;
    }

    public boolean isPacemaker() {
        return pacemaker;
    }

    public boolean isDefibrillator() {
        return defibrillator;
    }

    public boolean isTripleRoom() {
        return tripleRoom;
    }

    public boolean isVentricularFibrillation() {
        return ventricularFibrillation;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setMechanicalValve(boolean mechanicalValve) {
        this.mechanicalValve = mechanicalValve;
    }

    public void setBiologicalValve(boolean biologicalValve) {
        this.biologicalValve = biologicalValve;
    }

    public void setStentsPose(boolean stentsPose) {
        this.stentsPose = stentsPose;
    }

    public void setAortoCoronaryBypass(boolean aortoCoronaryBypass) {
        this.aortoCoronaryBypass = aortoCoronaryBypass;
    }

    public void setPacemaker(boolean pacemaker) {
        this.pacemaker = pacemaker;
    }

    public void setDefibrillator(boolean defibrillator) {
        this.defibrillator = defibrillator;
    }

    public void setTripleRoom(boolean tripleRoom) {
        this.tripleRoom = tripleRoom;
    }

    public void setVentricularFibrillation(boolean ventricularFibrillation) {
        this.ventricularFibrillation = ventricularFibrillation;
    }
}

