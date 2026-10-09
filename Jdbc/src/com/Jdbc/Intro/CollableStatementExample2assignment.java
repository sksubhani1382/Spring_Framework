package com.Jdbc.Intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import java.sql.CallableStatement;


public class CollableStatementExample2assignment
{
	public static void main(String[] args) 
	{
		Connection con=null;
		CallableStatement cstmt=null;
		
		//load the drivers
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//get  the DB connection via Driver
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con=DriverManager.getConnection(dbURL);
			
			//issue the sql query via conection
			String calPro="call Student_Operation(?,?,?,?)";
			 cstmt=con.prepareCall(calPro);
			 
			 int nfid=Integer.parseInt(args[0]);
			 String nfName=args[1];
			 String nmName=args[2];
			 String nlName=args[3];
			 
			 cstmt.setInt(1,nfid);
			 cstmt.setString(2,nfName);
			 cstmt.setString(3,nmName);
			 cstmt.setString(4, nlName);
			 
			 cstmt.execute();
			 
			 System.out.println("Procedure executed for ID: " + nfid);

			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
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
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
