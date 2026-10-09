package com.dest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncludeServlet")
public class IncludeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String headerUrl = "/currentDate";
		String footerUrl = "/Login1.html";

		RequestDispatcher dispatcher = request.getRequestDispatcher(headerUrl);
		dispatcher.include(request, response);

		out.println("==================================================<br><br><br><br><br><br>");
		out.println("Information regarding the Appication<br><br><br><br>");
		out.println("==================================================<br><br><br><br><br><br>");

		RequestDispatcher dispatcher2 = request.getRequestDispatcher(footerUrl);
		dispatcher2.include(request, response);

	}

}
