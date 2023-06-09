package com.uptc.frw.executor;

import com.uptc.frw.conf.PersistenceUtil;
import com.uptc.frw.entity.Invoice;
import com.uptc.frw.entity.Product;
import com.uptc.frw.helpers.ProvidersMethods;
import jakarta.persistence.EntityManager;

import java.security.Provider;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        EntityManager em = PersistenceUtil.getEntityManager();
        ProvidersMethods providersMethods = new ProvidersMethods();

        // Metodo para insertar 5 registros de todas las tablas a la vez
        providersMethods.insertData(em);
        System.out.println("Data saved succesful!");

        // Metodo para obtener las facturas de un cliente

        List<Invoice> invoices = providersMethods.getInvoicesById(5l, em);

        if (invoices != null && !invoices.isEmpty()) {
            System.out.println("Facturas del cliente:");

            for (Invoice invoice : invoices) {
                System.out.println("ID: " + invoice.getId());
                System.out.println("Fecha: " + invoice.getInvoiceDate());
                System.out.println("Total: " + invoice.getClient().getNames());
            }
        } else {
            System.out.println("No se encontraron facturas para el cliente.");
        }

        //Método que permite consultar los productos que provee un proveedor.

        List<Product> products = providersMethods.getProductsByProvider(13l, em);

        if (products != null && !products.isEmpty()) {
            System.out.println("Productos del proveedor:");

            for (Product product : products) {
                System.out.println("ID: " + product.getId());
                System.out.println("Nombre: " + product.getName());
                System.out.println("Precio: " + product.getUnitPrice());
            }
        } else {
            System.out.println("No se encontraron productos para el proveedor.");
        }

        //Método que a partir del id del vendedor muestra el valor total de las ventas de este.

        double totalSalesValue = providersMethods.getTotalSalesBySeller(13l, em);
        System.out.println(totalSalesValue);

        //Metodo para mostrar la factura
        providersMethods.showInvoice(2l, em);

        em.close();
    }
}