package com.shrihari.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        /*
//        Method - 1 using merge
        Student s1 = new Student();
        s1.setRollNo(107);
        s1.setsName("Haris");
        s1.setsAge(16);

        session.merge(s1);
         */


//        Method - 2 using get
        Student s1 = session.get(Student.class, 107);

        if (s1 != null) {
            s1.setsName("Shriiii");
            s1.setsAge(18);
        }

        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);
    }
}
