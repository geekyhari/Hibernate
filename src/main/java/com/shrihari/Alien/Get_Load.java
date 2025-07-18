package com.shrihari.Alien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get_Load {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();

//        Laptop laptop = session.get(Laptop.class, 2);
        Laptop laptop = session.byId(Laptop.class).getReference(2);
        System.out.println(laptop);

        session.close();
        sf.close();
    }
}
