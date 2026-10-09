package com.dest.controller;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dest.dto.InterviewBean;
import com.dest.dto.RoundBean;
import com.dest.dto.StudentBean;

public class Client {
	public static void main(String[] args) 
	{
		  /*Resource resource=new ClassPathResource("beans.xml"); 
		  BeanFactory beanFactory=new XmlBeanFactory(resource); 
		  StudentBean sBean=(StudentBean) beanFactory.getBean("ref"); sBean.getMessage();
		 */
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		StudentBean sb=(StudentBean) context.getBean("ref");
		sb.getMessage();
		
		InterviewBean iBean=(InterviewBean)context.getBean("iRef");
		
		String iName=iBean.getIName();
		String iType=iBean.getIType();
		int noOfVac=iBean.getNoOfVac();
		RoundBean rBean=iBean.getBean();
		int nRound=rBean.getNoOfRounds();
		String rType=rBean.getrType();
		
		System.out.println("-------------------------------------");
		System.out.println("The Interview Name is: "+iName);
		System.out.println("The Interview Type is: "+iType);
		System.out.println("The Interview noOfvac is: "+noOfVac);
		System.out.println("The Interview Rounds is: "+nRound);
		System.out.println("The Interview Round Type is: "+rType);
		System.out.println("-------------------------------------");

		
	}
}
