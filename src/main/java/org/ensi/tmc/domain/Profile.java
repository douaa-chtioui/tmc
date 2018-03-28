package org.ensi.tmc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Profile {

    @Id
    @GeneratedValue
    private long identifier;

    private String gender;
    private boolean smoker;
    private boolean menopause ;
    private int height;
    private int weight;
    private boolean married ;
    private boolean diabetic ;
    private boolean hypertensive ;
    private boolean dyslipidemic ;
    private boolean personalAntecedent;
    private boolean familyAntecedent;

    public long getIdentifier() {
        return identifier;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMenopause() {
        return menopause;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isMarried() {
        return married;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public boolean isHypertensive() {
        return hypertensive;
    }

    public boolean isDyslipidemic() {
        return dyslipidemic;
    }

    public boolean isPersonalAntecedent() {
        return personalAntecedent;
    }

    public boolean isFamilyAntecedent() {
        return familyAntecedent;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmocker(boolean smoker) {
        this.smoker = smoker;
    }

    public void setMenopause(boolean menopause) {
        this.menopause = menopause;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public void setHypertensive(boolean hypertensive) {
        this.hypertensive = hypertensive;
    }

    public void setDyslipidemic(boolean dyslipidemic) {
        this.dyslipidemic = dyslipidemic;
    }

    public void setPersonalAntecedent(boolean personalAntecedent) {
        this.personalAntecedent = personalAntecedent;
    }

    public void setFamilyAntecedent(boolean familyAntecedent) {
        this.familyAntecedent = familyAntecedent;
    }

}


