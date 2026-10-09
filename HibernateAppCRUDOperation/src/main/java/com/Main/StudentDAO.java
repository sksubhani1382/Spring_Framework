package com.Main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Model.StudentInfo;

public class StudentDAO {

    // CREATE
    public void save(StudentInfo s) 
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);   

        tx.commit();
        session.close();
        System.out.println("Saved!");
    }

    // READ
    public StudentInfo get(int id) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        StudentInfo s = session.get(StudentInfo.class, id);
        session.close();
        return s;
    }

    // UPDATE
    public void update(StudentInfo s) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(s);

        tx.commit();
        session.close();
        System.out.println("Updated!");
    }

    // DELETE
    public void delete(int id) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        StudentInfo s = session.get(StudentInfo.class, id);
        if (s != null) 
        {
            session.delete(s);
            System.out.println("Deleted!");
        }

        tx.commit();
        session.close();
    }
}
