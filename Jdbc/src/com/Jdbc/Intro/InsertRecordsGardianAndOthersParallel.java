package com.Jdbc.Intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecordsGardianAndOthersParallel {

	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		//Load the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get the DB connection via Driver
			String dbURL="jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con=DriverManager.getConnection(dbURL);
			
			//issue the sql query via connection
			
			            //student_gardian_info insertion
			String query1="insert into student_gardian_info values(?,?,?,?,?)";
			pstmt1=con.prepareStatement(query1); 
			pstmt1.setInt(1, Integer.parseInt(args[0])); 
			int id = Integer.parseInt(args[1]); 
            pstmt1.setInt(2, id);                        
            pstmt1.setString(3, args[2]);                
            pstmt1.setString(4, args[3]);                
            pstmt1.setString(5, args[4]);       
			
            //student_other_info insertion
            
            String query2="insert into student_other_info values(?,?,?,?)";
            pstmt2=con.prepareStatement(query2);
            pstmt2.setInt(1, Integer.parseInt(args[5]));
            pstmt2.setInt(2,id);
            pstmt2.setString(3,args[6]);
            pstmt2.setString(4, args[7]);
            
            int count1=pstmt1.executeUpdate();
            int count2=pstmt2.executeUpdate();
            
            //process th result returned by sql query
            
            if(count1>0 && count2>0)
            {
            	System.out.println("insertion records successfully...");
            }
            else
            {
            	System.out.println("Unable to record insertion...");
            }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//close all connections
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt1!=null)
				{
					pstmt1.close();
				}
				if(pstmt2!=null)
				{
					pstmt2.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
