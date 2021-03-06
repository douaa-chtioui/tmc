CREATE TABLE NOTIFICATION (
    IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
    TEXT varchar(255),
    CATEGORY varchar(255),
    PRIMARY KEY (IDENTIFIER)
);

CREATE TABLE PROFILE (
    IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
    DIABETIC BOOLEAN NOT NULL,
    DYSLIPIDEMIC BOOLEAN NOT NULL,
    FAMILY_ANTECEDENT BOOLEAN NOT NULL,
    GENDER VARCHAR(255),
    HEIGHT INTEGER NOT NULL,
    HYPERTENSIVE BOOLEAN NOT NULL,
    MARRIED BOOLEAN NOT NULL,
    MENOPAUSE BOOLEAN NOT NULL,
    PERSONAL_ANTECEDENT BOOLEAN NOT NULL,
    SMOKER BOOLEAN NOT NULL,
    WEIGHT INTEGER NOT NULL,
    PRIMARY KEY (IDENTIFIER)
);

CREATE TABLE CHRONIC_DISEASE (
    IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
    DISEASE varchar(255) NOT NULL,
    MECHANICAL_VALVE BOOLEAN NOT NULL,
    BIOLOGICAL_VALVE BOOLEAN NOT NULL,
    STENTS_POSE BOOLEAN NOT NULL,
    AORTO_CORONARY_BYPASS BOOLEAN NOT NULL,
    PACEMAKER BOOLEAN NOT NULL,
    DEFIBRILLATOR BOOLEAN NOT NULL,
    TRIPLE_ROOM BOOLEAN NOT NULL,
    VENTRICULAR_FIBRILLATION BOOLEAN NOT NULL,
    PRIMARY KEY (IDENTIFIER)
);


CREATE TABLE USER (
    IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
    TYPE VARCHAR(255) NOT NULL,
    AGE INTEGER,
    EMAIL VARCHAR(255) NOT NULL,
    FIRSTNAME VARCHAR(255) NOT NULL,
    LASTNAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    ADRESS VARCHAR(255),
    CODE VARCHAR(8),
    PROFILE_ID BIGINT,
    CHRONIC_DISEASE_ID BIGINT,
    DOCTOR_ID BIGINT,
    PRIMARY KEY (IDENTIFIER)
);

CREATE TABLE CHECKUP (
    IDENTIFIER BIGINT NOT NULL AUTO_INCREMENT,
    USER_ID BIGINT NOT NULL,
    CHECKUP_DATE TIMESTAMP NOT NULL,
    PATIENT_COMMENT VARCHAR(255),
    DOCTOR_COMMENT VARCHAR(255),
    PRIMARY KEY (IDENTIFIER)
);

ALTER TABLE USER ADD CONSTRAINT user_profile_id FOREIGN KEY (PROFILE_ID) REFERENCES PROFILE;
ALTER TABLE USER ADD CONSTRAINT chronic_disease_id FOREIGN KEY (CHRONIC_DISEASE_ID) REFERENCES CHRONIC_DISEASE;
ALTER TABLE USER ADD CONSTRAINT user_doctor_id FOREIGN KEY (DOCTOR_ID) REFERENCES USER;
ALTER TABLE CHECKUP ADD CONSTRAINT checkup_user_id FOREIGN KEY (USER_ID) REFERENCES USER;