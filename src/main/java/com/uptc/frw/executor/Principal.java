package com.uptc.frw.executor;

import com.uptc.frw.conf.PersistenceUtil;
import com.uptc.frw.entity.*;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class Principal {

    public static void main(String[] args) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Person cliente = em.find(Person.class, 1l);
        Person seller = em.find(Person.class, 2l);
        Invoice invoice = new Invoice(new Date(), cliente, seller);
        em.persist(invoice);
        System.out.println(invoice);
        em.getTransaction().commit();
        em.close();
    }
}