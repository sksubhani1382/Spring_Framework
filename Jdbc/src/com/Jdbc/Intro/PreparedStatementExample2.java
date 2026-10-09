package com.Jdbc.Intro;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
public class PreparedStatementExample2 {

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
						String query="insert into student_info values(?,?,?,?)";
						pstmt=con.prepareStatement(query);
						int id=Integer.parseInt(args[0]);
						String fname=args[1];
						String mname=args[2];
						String lname=args[3];
						
						
					    pstmt.setInt(1,id);
					    pstmt.setString(2,fname);
					    pstmt.setString(3, mname);
					    pstmt.setString(4, lname);
						 
					    int count=pstmt.executeUpdate();
					    //process the result returned by sql query
						 if(count>0)
						 {
							 System.out.println("Insertion is successfully..."); 
						 }
						 else
						 {
							 System.out.println("Unable to insert the records");
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
							}
							catch(SQLException e)
							{
								e.printStackTrace();
							}			
						
					} 	
			}
		

	}


