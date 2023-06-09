package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSONS")
public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @SequenceGenerator(name = "seq_person", sequenceName = "person_seq", allocationSize = 1)
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

    @OneToMany(mappedBy = "client")
    private List<Invoice> clientInvoiceList;
    @OneToMany(mappedBy = "seller")
    private List<Invoice> sellerInvoiceList;

    @ManyToMany(mappedBy = "providers")
    private List<Product> products;

    public Person(){

    }

    public Person(String names, String lastNames, Date birthDate, String identificationType, String identificationNumber) {
        this.names = names;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
    }

    public Person(Long id, String names, String lastNames, Date birthDate, String identificationType, String identificationNumber) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
    }

    public Person(Long id, String names, String lastNames, Date birthDate, String identificationType, String identificationNumber, List<Invoice> clientInvoiceList, List<Invoice> sellerInvoiceList, List<Product> products) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.clientInvoiceList = clientInvoiceList;
        this.sellerInvoiceList = sellerInvoiceList;
        this.products = products;
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

    public List<Invoice> getClientInvoiceList() {
        return clientInvoiceList;
    }

    public void setClientInvoiceList(List<Invoice> clientInvoiceList) {
        this.clientInvoiceList = clientInvoiceList;
    }

    public List<Invoice> getSellerInvoiceList() {
        return sellerInvoiceList;
    }

    public void setSellerInvoiceList(List<Invoice> sellerInvoiceList) {
        this.sellerInvoiceList = sellerInvoiceList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", birthDate=" + birthDate +
                ", identificationType='" + identificationType + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                '}';
    }
}
