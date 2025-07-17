package com.shrihari.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

/*
//        Method - 1 using delete/remove -> fetch and delete
        Student s1 = session.get(Student.class, 106);
        if (s1 != null) {
            session.delete(s1);
        }
 */

//        Method - 2 -> direct delete w/o fetching
        Student student = new Student();
        student.setRollNo(107);

        session.remove(student);

        transaction.commit();
        session.close();
        sf.close();
//        System.out.println(s1);
    }
}
