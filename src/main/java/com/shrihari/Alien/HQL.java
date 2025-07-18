package com.shrihari.Alien;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQL {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();

        /* Insert
        Transaction transaction = session.beginTransaction();

        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("ASUS");
        l1.setModel("ROG");
        l1.setRam(32);

        session.persist(l1);

        transaction.commit();*/

        Query query = session.createQuery("select Brand, Model from Laptop where Brand like ?1");
        query.setParameter(1,"ASUS");
        List<Object[]> laptops = query.getResultList();

//        Laptop l2 = session.get(Laptop.class, 2);

        for(Object[] d : laptops){
            System.out.println(d[0]+" "+d[1]);
        }

        System.out.println(laptops);
        session.close();
        sf.close();
    }
}
