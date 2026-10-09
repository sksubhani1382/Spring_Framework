package com.dest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class RemoveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));

		// write the JDBC code here to fetch Student_info table
		String viewStudntsUrl = "http://localhost:8080/StudentApp1/viewAllStu";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1 Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// 2 get the DB connection via Driver
			String dbURL = "jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con = DriverManager.getConnection(dbURL);

			// 3. Issue th sql queries via connection
			String query = " delete from student_info where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				out.println("The Idno :" + id + " is Deleted Successfully..<br><br>");
				out.println(" <a href=" + viewStudntsUrl + ">Click Here</a> View All Students Information");

			} else {
				out.println("The Idno :" + id + " is unable to Delete..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5.close all the jdbc Connections/Objects
		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} // end of try catch

		} // end of finally

	}
}
