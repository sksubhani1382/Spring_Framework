package com.dest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class ViewAllStudentsInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		// write the JDBC code here to fetch Student_info table

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1 Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// 2 get the DB connection via Driver
			String dbURL = "jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con = DriverManager.getConnection(dbURL);

			// 3. Issue th sql queries via connection

			String query = "select *from student_info";
			stmt = con.createStatement();

			rs = stmt.executeQuery(query);

			// 4. Process the result returned by sql query
			out.println("The Student Info Data Is...");

			out.println("<html>");
			out.println("<body>");
			out.println("<table border=\"1px solid black\">");
			out.println("<tr>");
			out.println("<th>Idno</th>");
			out.println("<th>First Name</th>");
			out.println("<th>Middle Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");

			while (rs.next()) {

				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String middle_name = rs.getString("middle_name");
				String last_name = rs.getString("last_name");

				out.println("<tr>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + first_name + "</td>");
				out.println("<td>" + middle_name + "</td>");
				out.println("<td>" + last_name + "</td>");
				out.println("<td><a href=\"http://localhost:8080/StudentApp1/editServ?id=" + id + "\">Edit</a></td>");
				out.println(
						"<td><a href=\"http://localhost:8080/StudentApp1/deleteServ?id=" + id + "\">Delete</a></td>");

				out.println("</tr>");

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
				if (stmt != null) {
					stmt.close();
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
