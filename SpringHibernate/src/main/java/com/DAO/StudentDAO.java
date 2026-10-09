package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.cglib.core.ClassesKey;

import com.TableBean.Student;


public class StudentDAO
{
	 private SessionFactory sFactory;

	public SessionFactory getsFactory() {
		return sFactory;
	}
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}
	 public void saveOrUpdateStudent(Student student)
	 {
		 Session session=null;
		 Transaction tx=null;
		 
		 try {
			 session=sFactory.openSession();
			 tx=session.beginTransaction();
			 
			 Student existing=session.get(student.getClass(), student.getId());
			 
			 if(existing==null)
			 {
				 session.save(student);
				 System.out.println("Student save successfully");
			 }
			 else
			 {
				 session.merge(student);
				 System.out.println("Student Updated successfully");
			 }
			 tx.commit();
		 }
		 catch (RuntimeException e) 
		 {
			if(tx!=null)
			{
				tx.rollback();
				throw e;
			}
		}
		 
		 finally {
			if(session!=null)
				session.close();
		}
		 
		 
			/*
			 * Session session=sFactory.openSession(); 
			 * Transaction tx=
			 * session.beginTransaction(); 
			 * session.saveOrUpdate(student); 
			 * tx.commit();
			 * session.close(); 
			 * System.out.println();
			 */
	 }
	 
}
