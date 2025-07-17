package com.shrihari.Alien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("ASUS");
        l1.setModel("TUF F15");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("DELL");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("APPLE");
        l3.setModel("Macbook Air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Shrihari");
        a1.setTech("JAVA");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Amogh");
        a2.setTech("JS");

        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("Harsh");
        a3.setTech("Python");

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3,l2));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAliens(Arrays.asList(a1,a3));
        l2.setAliens(Arrays.asList(a1,a2));
        l3.setAliens(Arrays.asList(a2));

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();
        Alien a5 = session.get(Alien.class,102);
        System.out.println(a5);

        session.close();
        sf.close();
    }
}
