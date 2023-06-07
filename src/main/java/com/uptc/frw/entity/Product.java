package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @SequenceGenerator(name = "seq_product", sequenceName = "product_seq", allocationSize = 1)
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String name;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;
    @ManyToMany
    @JoinTable(name = "PRODUCT_PROVIDER", joinColumns = @JoinColumn(name = "ID_PRODUCT"), inverseJoinColumns = @JoinColumn(name = "ID_PROVIDER"))
    private List<Person> providers;
    @OneToMany(mappedBy = "product")
    private List<Detail> detailsList;

    public Product() {
    }

    public Product(Long id, String name, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Product(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Person> getProviders() {
        return providers;
    }

    public void setProviders(List<Person> providers) {
        this.providers = providers;
    }

    public List<Detail> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<Detail> detailsList) {
        this.detailsList = detailsList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
