package com.dest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class LoginServlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter outer = resp.getWriter();
		String viewStudntsUrl = "http://localhost:8080/StudentApp1/viewAllStu";

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		// write the JDBC code here to fetch Student_info table
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
			String query = "SELECT * FROM student_info si " + "JOIN student_other_info soi ON si.id = soi.id "
					+ "WHERE si.first_name = ? AND soi.password = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			// 4. Process the result returned by sql query
			if (rs.next()) {
				outer.println("Loggedin Successfully....!");
				outer.println("welcome to StudentAppp   " + userName + "  </br></br>");
				outer.println(" <a href=" + viewStudntsUrl + ">Click Here</a> View All Students Information");

			} else {
				outer.println("username / password is incorrect...!");
			}

		} catch (SQLException e) {
			outer.println("username / password is incorrect...!");
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
