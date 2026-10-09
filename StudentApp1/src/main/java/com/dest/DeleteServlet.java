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

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));

		// write the JDBC code here to fetch Student_info table

		String cancelUrl = "http://localhost:8080/StudentApp1/viewAllStu";
		String deleteurl = "http://localhost:8080/StudentApp1/removeServ";

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
			String query = "select * from student_info where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			out.println("Are you sure You want to Delete this Record..?");

			out.println("<html>");
			out.println("<body>");
			out.println("<table border=\"1px solid black\">");
			out.println("<form action=" + deleteurl + " method=\"POST\">");

			if (rs.next()) {

				int Id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String middle_name = rs.getString("middle_name");
				String last_name = rs.getString("last_name");

				out.println("<tr>");
				out.println(
						"<td>Id :</td><td><input type=\"text\" name=\"id\" readonly=\"true\" value=" + Id + "> </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println(
						"<td>First Name :</td><td><input type=\"text\" name=\"first_name\" readonly=\"true\"  value="
								+ first_name + "> </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println(
						"<td>Middle Name :</td><td><input type=\"text\" name=\"middle_name\"  readonly=\"true\"  value="
								+ middle_name + "> </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Last Name :</td><td><input type=\"text\" name=\"last_name\" readonly=\"true\"  value="
						+ last_name + "> </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td></td><td><input type=\"submit\"   value=\"delete\">  <a  href=" + cancelUrl
						+ "> cancel  </a> </td>");
				out.println("</tr>");

				out.println("</tr>");

			}

			out.println("</form>");
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
