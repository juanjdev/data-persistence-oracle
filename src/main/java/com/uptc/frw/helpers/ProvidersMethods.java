package com.uptc.frw.helpers;

import com.uptc.frw.entity.Detail;
import com.uptc.frw.entity.Invoice;
import com.uptc.frw.entity.Person;
import com.uptc.frw.entity.Product;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProvidersMethods {

    public static void insertData(EntityManager em){
        em.getTransaction().begin();
        for (int i = 0; i < 5; i++) {
            Person provider = new Person("Proveedor " + i, "Apellidos " + i, new Date(), "PR", "2378187PROVD" + i);
            Product product = new Product("Producto " + i, 12.0);
            Person client = new Person("Cliente " + i, "Apellidos " + i, new Date(), "CL", "2378187CLT" + i);
            Person seller = new Person("Vendedor " + i, "Apellidos " + i, new Date(), "VE", "2378187VEN" + i);
            ArrayList<Person> providersList = new ArrayList<>();
            providersList.add(provider);
            product.setProviders(providersList);
            Invoice invoice = new Invoice(new Date(), client, seller);
            Detail detail = new Detail(i * 2, 12.0, product, invoice);
            em.persist(provider);
            em.persist(product);
            em.persist(client);
            em.persist(seller);
            em.persist(invoice);
            em.persist(detail);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Invoice> getInvoicesById(Long clientId, EntityManager em){
        em.getTransaction().begin();
        try {
            Person client = em.find(Person.class, clientId);
            if(client != null) {
                return client.getClientInvoiceList();
            } else {
                System.out.println("Cliente no encontrado");
                return null;
            }
        } finally {
            em.close();
        }
    }

    public List<Product> getProductsByProvider(Long providerId, EntityManager em){
        em.getTransaction().begin();
        try {
            Person provider = em.find(Person.class, providerId);
            if(provider != null) {
                return provider.getProducts();
            } else {
                System.out.println("Proveedor no encontrado");
                return null;
            }
        } finally {
            em.close();
        }
    }

    public double getTotalSalesBySeller(Long idSeller, EntityManager em){
        em.getTransaction().begin();
        try{
            Person seller = em.find(Person.class, idSeller);
            double totalSales = 0.0;

            if(seller != null) {
                for(Invoice invoice : seller.getSellerInvoiceList()){
                    for(Detail detail : invoice.getDeatilsList()){
                        double sellPrice = detail.getSellingPrice();
                        int amount = detail.getAmount();
                        totalSales += sellPrice * amount;
                    }
                }
                return totalSales;
            } else {
                System.out.println("Vendedor no encontrado");
                return 0.0;
            }
        } finally {
            em.close();
        }
    }


    public void showInvoice(Long invoiceId, EntityManager em) {
        em.getTransaction().begin();
        try{
            Invoice invoice = em.find(Invoice.class, invoiceId);
            if(invoice != null) {
                System.out.println("Factura: " + invoice.getId());
                System.out.println("Cliente: " + invoice.getClient().getNames() + "\t\tFecha de compra: " + invoice.getInvoiceDate());
                System.out.println("\nId Item\t\tNombre Item\t\tCantidad\tValor unitario venta\tValor");
                double totalInvoice = 0.0;
                for(Detail detail : invoice.getDeatilsList()){
                    System.out.println(detail.getId() + "\t\t\t" + detail.getProduct().getName() + "\t\t\t" + detail.getAmount() +
                            "\t\t" + detail.getSellingPrice() + "\t\t\t\t" + detail.getSellingPrice() * detail.getAmount());
                    totalInvoice += detail.getSellingPrice() * detail.getAmount();
                }
                System.out.println("\nAtendido por: " + invoice.getSeller().getNames() + "\t\t\t\t\t\t\t\t" + "Total factura: " + totalInvoice);
            } else {
                System.out.println("La factura con el ID especificado no existe");
            }
        } finally {
            em.close();
        }

    }



}
