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

public class SearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		// get the id from browser

		int id = Integer.parseInt(req.getParameter("id"));

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// 2 get the DB connection via Driver
			String dbURL = "jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con = DriverManager.getConnection(dbURL);
			// 3. Isssue the SQl query via connection

			String query = "select * from student_info si,student_gardian_info sgi "
					+ " where si.id=sgi.id and si.id=?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			// set the regno from browser
			rs = pstmt.executeQuery();

			// 4. Process the result returned by the sql query.

			out.println("The Student Info Data Is...");

			out.println("<html>");
			out.println("<body>");
			out.println("<table border=\"1px solid black\">");
			out.println("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>First Name</th>");
			out.println("<th>Middle Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>G First Name</th>");
			out.println("<th>G Middle Name</th>");
			out.println("<th>G Last Name</th>");
			out.println("</tr>");

			if (rs.next()) {

				out.println("Id is found in the DataBase..!");

				int Id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String middle_name = rs.getString("middle_name");
				String last_name = rs.getString("last_name");

				String firstName = rs.getString("firstName");
				String middleName = rs.getString("middleName");
				String lastname = rs.getString("lastname");

				out.println("<tr>");
				out.println("<td><a href=\"http://localhost:8080/StudentApp1/id=" + Id + "\">" + Id + "</a></td>");
				out.println("<td>" + first_name + "</td>");
				out.println("<td>" + middle_name + "</td>");
				out.println("<td>" + last_name + "</td>");
				out.println("<td>" + firstName + "</td>");
				out.println("<td>" + middleName + "</td>");
				out.println("<td>" + lastname + "</td>");
				out.println("</tr>");

			} else {
				out.println("Id No is not found in the DataBase..!");

			}

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

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
