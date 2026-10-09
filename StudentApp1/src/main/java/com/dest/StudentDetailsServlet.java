
/*
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

public class StudentDetailsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		//String viewStudntsUrl="http://localhost:8080/StudentApp1/viewAllStu";

		int id = Integer.parseInt(req.getParameter("id"));
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
			String query = "select * from student_info si, student_other_info soi "
					+ "where si.id=soi.id and si.id=? and soi.password=?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
 
			// 4. Process the result returned by sql query
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
				out.println("<td><a href=\"http://localhost:8080/StudentApp1/id="+Id+"\">"+Id+"</a></td>");
				out.println("<td>"+first_name+"</td>");
				out.println("<td>"+middle_name+"</td>");
				out.println("<td>"+last_name+"</td>");
				out.println("<td>"+firstName+"</td>");
				out.println("<td>"+middleName+"</td>");
				out.println("<td>"+lastname+"</td>");
				out.println("</tr>");

				
			} else {
				out.println("Id Number is not found in the DataBase..!");

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
*/

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

public class StudentDetailsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. Load Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// 2. Get DB connection
			String dbURL = "jdbc:mysql://localhost:3306/J2EEBATCH?user=root&password=Rocket";
			con = DriverManager.getConnection(dbURL);

			// 3. SQL query to join student_info and student_other_info
			String query = "SELECT si.id, si.first_name, si.middle_name, si.last_name, " + "so.isAdmin, so.password "
					+ "FROM student_info si " + "JOIN student_other_info so ON si.id = so.id "
					+ "WHERE si.id = ? AND so.password = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			out.println("<html><body>");
			if (rs.next()) {
				out.println("<h3>Login Successful!</h3>");
				out.println("<h3>Student Details: </h3>");
				out.println("<table border='1'>");
				out.println(
						"<tr><th>ID</th><th>First Name</th><th>Middle Name</th><th>Last Name</th><th>isAdmin</th></tr>");

				int stuId = rs.getInt("id");
				String fname = rs.getString("first_name");
				String mname = rs.getString("middle_name");
				String lname = rs.getString("last_name");
				String isAdmin = rs.getString("isAdmin");

				out.println("<tr>");
				out.println("<td>" + stuId + "</td>");
				out.println("<td>" + fname + "</td>");
				out.println("<td>" + mname + "</td>");
				out.println("<td>" + lname + "</td>");
				out.println("<td>" + isAdmin + "</td>");
				out.println("</tr>");
				out.println("</table>");

				// Optional: Fetch guardian info also
				out.println("<br><h4>Guardian Details:</h4>");
				PreparedStatement pstmt2 = con.prepareStatement(
						"SELECT gid, firstName, middleName, lastName FROM student_gardian_info WHERE id = ?");
				pstmt2.setInt(1, id);
				ResultSet rs2 = pstmt2.executeQuery();

				if (rs2.next()) {
					out.println("<table border='1'>");
					out.println(
							"<tr><th>Guardian ID</th><th>First Name</th><th>Middle Name</th><th>Last Name</th></tr>");
					out.println("<tr>");
					out.println("<td>" + rs2.getInt("gid") + "</td>");
					out.println("<td>" + rs2.getString("firstName") + "</td>");
					out.println("<td>" + rs2.getString("middleName") + "</td>");
					out.println("<td>" + rs2.getString("lastName") + "</td>");
					out.println("</tr></table>");
				} else {
					out.println("<p>No guardian details found.</p>");
				}
				rs2.close();
				pstmt2.close();

			} else {
				out.println("<h3>Invalid ID or Password!</h3>");
			}
			out.println("</body></html>");

		} catch (SQLException e) {
			e.printStackTrace(out);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace(out);
			}
		}
	}
}
