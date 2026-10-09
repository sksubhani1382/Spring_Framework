package com.Jdbc.Intro;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class PreparedStatementExample1 {

	public static void main(String[] args)
	{
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			//Load the Driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//get the DB connection vai Driver
				String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
				con=DriverManager.getConnection(dbURL);
				
				//issue the sql query via connection
				String query="select *from student_info where id=?";
				pstmt=con.prepareStatement(query);
				String id=args[0];
				int idNum=Integer.parseInt(id);
			    pstmt.setInt(1,idNum);
				 
				 //process the result returned by sql query
				 rs=pstmt.executeQuery();
				 
				 while(rs.next())
					{
						int id1=rs.getInt("id");
						String first_name=rs.getString("first_name");
						String middle_name=rs.getString("middle_name");
						String last_name=rs.getString("last_name");
						
						System.out.println("=====================================");
						System.out.println("the regNo is: "+id1);
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
