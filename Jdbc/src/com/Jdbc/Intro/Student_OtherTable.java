package com.Jdbc.Intro;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Student_OtherTable {

	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			//load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//get the DB connection via Driver
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con=DriverManager.getConnection(dbURL);
			
			//issue the sql query via connection
			String query="select * from student_other_info where isAdmin=?";
			
			
			 pstmt=con.prepareStatement(query); 
			 String isAdmin=args[0]; 
			 pstmt.setString(1,isAdmin); 
			 rs = pstmt.executeQuery();
			/*
			 * stmt=con.createStatement(); rs=stmt.executeQuery(query);
			 */
		    
		  //process the result returned by sql query
		    while(rs.next())
		    {
		    	int oid=rs.getInt("oid");
				int id=rs.getInt("id");
				String isAdmin1=rs.getString("isAdmin");
				String password=rs.getString("password");
				
				System.out.println("==============================");
				System.out.println("gid is: "+oid);
				System.out.println("id is: "+id);
				System.out.println("isAdmin is: "+isAdmin1);
				System.out.println("is password: "+password);
				System.out.println("==============================");
		    }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		//close all jdbc connections
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
					con.close();
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

