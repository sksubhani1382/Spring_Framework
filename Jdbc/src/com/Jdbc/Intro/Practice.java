package com.Jdbc.Intro;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Practice 
{
	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			//get the DB connection via Driver
			con=DriverManager.getConnection(dbUrl);
			//issue the sql query via that connection
			String query="select * from StudentInfo";
			st=con.createStatement();
			rs=st.executeQuery(query);
			
			//process the result return by sql query
			while(rs.next())
			{
				int id=rs.getInt("id");
				String first_name=rs.getString("firstName");
				String middle_name=rs.getString("middleName");
				String last_name=rs.getString("lastName");
				System.out.println("==========================================");
				System.out.println("the RegNo is: "+id);
				System.out.println("the Firstname is: "+first_name);
				System.out.println("The middleName is: "+middle_name);
				System.out.println("the lastName is: "+last_name);
				System.out.println("=============================================");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try {
				if(con!=null)
				{
					con.close();
				}
				if(st!=null)
				{
					st.close();
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
