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

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String first_name = req.getParameter("first_name");
		String middle_name = req.getParameter("middle_name");
		String last_name = req.getParameter("last_name");

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

			String query = " update student_info " + " set first_name=?, middle_name=?,last_name=? " + " where id=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, first_name);
			pstmt.setString(2, middle_name);
			pstmt.setString(3, last_name);
			pstmt.setInt(4, id);
			int count = pstmt.executeUpdate();

			if (count > 0) {
				out.println("The Idno :" + id + " is updated Successfully..");
			} else {
				out.println("The Idno :" + id + " is unable to update..");
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
