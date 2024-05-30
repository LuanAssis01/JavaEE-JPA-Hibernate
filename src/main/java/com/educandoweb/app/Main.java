package com.educandoweb.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.educandoweb.dominio.Person;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Person p = em.find(Person.class, 2);
        System.out.println(p);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto!");

        em.close();
        emf.close();
        
    }
}
