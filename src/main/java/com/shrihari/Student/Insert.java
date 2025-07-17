package com.shrihari.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRollNo(107);
        s1.setsName("Harish");
        s1.setsAge(16);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);

    }

}