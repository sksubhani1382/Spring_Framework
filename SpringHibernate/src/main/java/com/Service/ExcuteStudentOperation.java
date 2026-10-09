package com.Service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.DAO.StudentDAO;
import com.TableBean.Student;

public class ExcuteStudentOperation 
{
	public static void main(String[] args) {
		
		Resource resource=new ClassPathResource("SpringHibernate.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		StudentDAO dao=(StudentDAO)beanFactory.getBean("sRef");
		
		Student student=new Student();
		student.setId(3);
		student.setName("og");
		student.setAddres("hyderabad");
		student.setEmail("OgGambeera@gmal.com");
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getAddres());
		
	
		dao.saveOrUpdateStudent(student);
		
			
		 
			
	}

}
