package com.uptc.frw.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DETAILS")
public class Detail {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detail")
    @SequenceGenerator(name = "seq_detail", sequenceName = "detail_seq", allocationSize = 1)
    private Long id;
    @Column(name = "AMOUNT")
    private Integer amount;
    @Column(name = "SELL_PRICE")
    private Double sellingPrice;
    @Column(name = "ID_PRODUCT", insertable = false, updatable = false)
    private Long idProduct;
    @Column(name = "ID_INVOICE", insertable = false, updatable = false)
    private Long idInvoice;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ID_INVOICE", nullable = false)
    private Invoice invoice;

    public Detail(){

    }

    public Detail(Long id, Integer amount, Double sellingPrice, Long idProduct, Long idInvoice) {
        this.id = id;
        this.amount = amount;
        this.sellingPrice = sellingPrice;
        this.idProduct = idProduct;
        this.idInvoice = idInvoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }



    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", amount=" + amount +
                ", sellingPrice=" + sellingPrice +
                ", idProduct=" + idProduct +
                ", idInvoice=" + idInvoice +
                '}';
    }
}
