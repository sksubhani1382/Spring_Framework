package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.StudentInfo;

public class MyFirstHibernateExample {
	public static void main(String[] args) {
		
		
		//load the Configuration
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		
		//Bulid the sessionFactory
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//open the session object
		Session session=sessionFactory.openSession();
		
		//process the Data
		StudentInfo info=new StudentInfo();
		
		info.setId(5);
		info.setFirstName("sareena");
		info.setMiddleName("subhani");
		info.setLastName("lavanya");
		
		session.beginTransaction();
		session.saveOrUpdate(info);
		
		System.out.println("save the Record Successfully...");
		System.out.println(info.getId()+" "+info.getFirstName()+" "+info.getMiddleName()+" "+info.getLastName());
		
		session.flush();
		session.getTransaction().commit();
		//close the session
		session.close();
		
	}
}
