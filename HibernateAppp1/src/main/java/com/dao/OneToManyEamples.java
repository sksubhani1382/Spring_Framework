  package com.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.User;

public class OneToManyEamples
{
	public static void main(String[] args) {
		
		//load the Configuration
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		//build the SesssionFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//open Sesion
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		//process the Data
		User user=new User();
		user.setUid(1);
		user.setUserName("vikram");
		user.setUserEmail("vikram12@gamil.com");
		user.setPhoneNo(456789123);
		
		Address address1=new Address();
		address1.setaId(11);
		address1.setAddress1("Andhra");
		address1.setAddress2("kanigiri Twon");
		address1.setAddress3("Chowtagogulapalli");
		address1.setUser(user);
		
		Address address2=new Address();
		address2.setaId(12);
		address2.setAddress1("bangalore");
		address2.setAddress2("BTYM Layout");
		address2.setAddress3("Maruthi nagar");
		address2.setUser(user);
		
		Set<Address>set=new HashSet<Address>();
		set.add(address1);
		set.add(address2);
		
		user.setAddress(set);
		
		session.save(user);
		
		session.getTransaction().commit();
		
		//close 
		session.flush();
		session.close();
		
	}

}
