/*
package com.dao;
 


import java.util.List;
import java.util.Queue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.StudentInfo;

public class HibernateClauses 
{
	public static void main(String[] args) {
		
		//load the Configuration
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		
		//build the sessionFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//open session
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
	//String hql="select a from StudentInfo a";
		//String hql="select a from StudentInfo a where a.id=7";
		//String hql="select a from StudentInfo a order by a.id DESC";
				
				
				
		String hql = " delete from  StudentInfo a "
			       + " where a.id =:varId_NO ";

		StudentInfo info=new StudentInfo();
		info.setId(2);
		
 		int count = session.createQuery(hql)
 				    .setParameter("varId_NO", info.
 				    		getId())
 				    .executeUpdate();
 		
 		/*
		 * List<StudentInfo>list=session.createQuery(hql).list();
		 * System.out.println("Stuedent info is..."); for(StudentInfo si:list) {
		 * System.out.println("=======================");
		 * System.out.println("Id is: "+si.getId());
		 * System.out.println("First Name is: "+si.getFirstName());
		 * System.out.println("MiddleName is: "+si.getMiddleName());
		 * System.out.println("Last name is: "+si.getLastName());
		 * System.out.println("================================"); }
		 */
 		
/*		System.out.println("The Student Info is........!");

	 if(count>0) {
		 System.out.println("the Id is deleted...!");
	 }else {
		 System.out.println("the Id is not deleted...!");

	 }
	 session.getTransaction().commit();
		session.flush();
		session.close();
	}
}

*/

//Update Query
package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateClauses {
    public static void main(String[] args) {
        
        // load the Configuration
        Configuration cfg = new Configuration().configure();
        
        // build the sessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // open session
        Session session = sessionFactory.openSession();
        
        // begin transaction
        session.beginTransaction();

        // ✅ Correct HQL update query (no extra comma)
        String hql = "update StudentInfo a set a.firstName = :varFirst_Name, a.middleName = :varMiddle_Name where a.id = :varId_No";

        // create query
        Query query = session.createQuery(hql);
        query.setParameter("varFirst_Name", "ss");
        query.setParameter("varMiddle_Name", "mm");
        query.setParameter("varId_No", 5);

        // execute update
        int count = query.executeUpdate();

        System.out.println(" Records updated: " + count);

        // commit transaction
        session.getTransaction().commit();
        
        // close session
        session.close();
        sessionFactory.close();
    }
}

