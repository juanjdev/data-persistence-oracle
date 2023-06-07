package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_invoice")
    @SequenceGenerator(name = "seq_invoice", sequenceName = "invoice_seq", allocationSize = 1)
    private Long id;
    @Column(name = "INVOICE_DATE")
    private Date invoiceDate;
    @Column(name = "CLIENT_ID", insertable = false, updatable = false)
    private Long idClient;
    @Column(name = "SELLER_ID", insertable = false, updatable = false)
    private Long idSeller;
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Person client;
    @ManyToOne
    @JoinColumn(name = "SELLER_ID", nullable = false)
    private Person seller;
    @OneToMany(mappedBy = "invoice")
    private List<Detail> deatilsList;

    public Invoice() {
    }

    public Invoice(Date invoiceDate, com.uptc.frw.entity.Person client, com.uptc.frw.entity.Person seller) {
        this.invoiceDate = invoiceDate;
        this.client = client;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Long idSeller) {
        this.idSeller = idSeller;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Person getSeller() {
        return seller;
    }

    public void setSeller(Person seller) {
        this.seller = seller;
    }

    public List<Detail> getDeatilsList() {
        return deatilsList;
    }

    public void setDeatilsList(List<Detail> deatilsList) {
        this.deatilsList = deatilsList;
    }
}
