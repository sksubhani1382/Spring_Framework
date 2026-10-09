package com.Jdbc.Intro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
public class MyFirstJdbc {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			//Load the Drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Get the DB connection via Driver
			
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			
			con=DriverManager.getConnection(dbURL);
			//issue the sql query via the connection
			String query="select * from student_info";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			//process the result returned by the sql query
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
				System.out.println("=========================================");
				
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
