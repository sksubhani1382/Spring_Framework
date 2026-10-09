package com.Jdbc.Intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
public class InsertStudentInfo {

	public static void main(String[] args) 
	{
	Connection con=null;
	Statement stmt=null;
	try
	{
		//Load the Drivers
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Get the DB connection via Driver
		
		String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
		
		con=DriverManager.getConnection(dbURL);
		//issue the sql query via the connection
		String query="insert into student_info values(5,'simon','kaala','khaja')";
		stmt=con.createStatement();
		int count=stmt.executeUpdate(query);
		
		//process the result returned by the sql query
		if(count>0)
		{
			System.out.println("Record inserted successfully..");
		}
		else
		{
			System.out.println("unable to insert record...");		
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	//close all the jdbc connections
	finally
	{
		try
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
}
