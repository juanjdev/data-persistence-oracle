package com.uptc.frw.executor;

import com.uptc.frw.conf.PersistenceUtil;
import com.uptc.frw.entity.*;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class Principal {

    public static void main(String[] args) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person = new Person("Juan Jose", "Blanco Mendoza", new Date(), "CC", "1193065403");
        em.getTransaction().begin();
        em.persist(person);
        System.out.println(person);
        em.getTransaction().commit();
        em.close();
    }
}