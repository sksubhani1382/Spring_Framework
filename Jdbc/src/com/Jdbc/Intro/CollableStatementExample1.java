package com.Jdbc.Intro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CollableStatementExample1 {

	public static void main(String[] args)
	{
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try
		{
		//load the Drivers
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Get the DB Connection via Driver
		String dbUrl="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
		con=DriverManager.getConnection(dbUrl);
		
		//issue the sql query via connection
		String query="call getAllStudents()";
		cstmt=con.prepareCall(query);
		boolean flag=cstmt.execute();
		
		//process the result returned via sql query
		if(flag)
		{
			System.out.println("DB result in the form rows and columns");
			rs=cstmt.getResultSet();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String first_name=rs.getString("first_name");
				String middle_name=rs.getString("middle_name");
				String last_name=rs.getString("last_name");
				
				System.out.println("=====================================");
				System.out.println("the regNo is: "+id);
				System.out.println("the FirstName is: "+first_name);
				System.out.println("the middleName is: "+middle_name);
				System.out.println("the lastName is: "+last_name);
				System.out.println("=====================================");
			}
		}
		else
		{
			int count=cstmt.getUpdateCount();
			System.out.println("No.of rows effected by count: "+count);
		}			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(cstmt!=null)
				{
					cstmt.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
