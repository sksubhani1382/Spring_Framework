package com.Jdbc.Intro;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class Student_GardianTable {

	public static void main(String[] args)  
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//get the DB connection via Driver
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con=DriverManager.getConnection(dbURL);
			
			//issue the connection sql query
			String query="select * from student_gardian_info";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			//process the result returned by sql
			while(rs.next())
			{
				int gid=rs.getInt("gid");
				int id=rs.getInt("id");
				String firstName=rs.getString("firstName");
				String middleName=rs.getString("middleName");
				String lastName=rs.getString("lastName");
				
				System.out.println("==============================");
				System.out.println("gid is: "+gid);
				System.out.println("id is: "+id);
				System.out.println("firstName is: "+firstName);
				System.out.println("middleName is: "+middleName);
				System.out.println("lastName is: "+lastName);
				System.out.println("==============================");
				
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			try {
				while(con!=null)
				{
					con.close();
				}
				while(stmt!=null)
				{
					stmt.close();
				}
				
				while(rs!=null)
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
