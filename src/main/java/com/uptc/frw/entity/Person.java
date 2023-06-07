package com.uptc.frw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSONS")
public class Person {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAMES")
    private String names;
    @Column(name = "LAST_NAMES")
    private String lastNames;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "DOC_TYPE")
    private String identificationType;
    @Column(name = "DOC_NUMBER")
    private String identificationNumber;

    public Person(){

    }

    public Person(Long id, String names, String lastNames, Date birthDate, String identificationType, String identificationNumber) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
