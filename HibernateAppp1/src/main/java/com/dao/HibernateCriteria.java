package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.model.StudentInfo;
public class HibernateCriteria 
{
	public static void main(String[] args) {
		
		//load the Configuration
		Configuration  cfg=new Configuration();
		cfg=cfg.configure();
		
		//build the sessionFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//open the session object
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		//process the data
		
		StudentInfo info=new StudentInfo();
		Criteria criteria=session.createCriteria(StudentInfo.class);
		List<StudentInfo>list=criteria.add(Restrictions.gt("id",1)).list();
		
		if(list!=null)
		{
			System.out.println("get StudentInfo Details...");
			for(StudentInfo si:list)
			{
				System.out.println("Id is: "+si.getId());
				System.out.println("FirstName is: "+si.getFirstName());
				System.out.println("MiddleName is: "+si.getMiddleName());
				System.out.println("LastName is: "+si.getLastName());

			}
		}
		else
		{
			System.out.println("StudentInfo Data is Not Available...");
		}
		
		session.flush();
		session.close();		
	}
}
