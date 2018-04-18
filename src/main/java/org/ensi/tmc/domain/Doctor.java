package org.ensi.tmc.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

    private String adress;
    private String code;

}
