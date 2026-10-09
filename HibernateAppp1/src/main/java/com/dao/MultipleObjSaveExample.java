package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.StudentGardianInfo;
import com.model.StudentInfo;

public class MultipleObjSaveExample {

	public static void main(String[] args) {
		
		//load the Configuration
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		
		//build the sesssonFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//open the session
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			
			StudentInfo info=new StudentInfo();
			info.setId(2);
			info.setFirstName("raj");
			info.setMiddleName("tej");
			info.setLastName("kaj");
			
			StudentGardianInfo sgi=new StudentGardianInfo();
			sgi.setGid(4);
			sgi.setGfirstName("varma");
			sgi.setGmiddleString("kk");
			sgi.setGlastName("vera");
			
			session.saveOrUpdate(info);
			session.saveOrUpdate(sgi);
			
			session.getTransaction().commit();
			session.flush();
			session.close();
			
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
		}
	}
}
