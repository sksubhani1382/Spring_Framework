package com.Jdbc.Intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class AssignmentFetchData 
{
	public static void main(String[] args) 
	{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//load the drivers
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			//Get the DB connection via Drivers
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con=DriverManager.getConnection(dbURL);
			
			//isssue the sql query via connection
			String query="SELECT si.id AS student_id,si.first_name,si.middle_name,si.last_name,sgi.gid AS guardian_id,sgi.firstName,sgi.middleName,sgi.lastName FROM student_info si JOIN student_gardian_info sgi ON si.id = sgi.id WHERE si.id = ?";
			 pstmt=con.prepareStatement(query);
			 
			 int id=Integer.parseInt(args[0]);
			 
			 pstmt.setInt(1, id);
			 
			 rs=pstmt.executeQuery();
			 
			 if(rs.next())
			 {
				 System.out.println("Student ID: " + rs.getInt("student_id"));
	                System.out.println("Student Name: " +
	                        rs.getString("first_name") + " " +
	                        rs.getString("middle_name") + " " +
	                        rs.getString("last_name"));
	                // Print guardian details
	                System.out.println("Guardian ID: " + rs.getInt("guardian_id"));
	                System.out.println("Guardian Name: " +
	                        rs.getString("firstName") + " " +
	                        rs.getString("middleName") + " " +
	                        rs.getString("lastName"));

			 }
			 else
			 {
				 System.out.println("student id "+id+" is not present both tables!!!");
			 }		
		} 
		
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		finally {
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
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
