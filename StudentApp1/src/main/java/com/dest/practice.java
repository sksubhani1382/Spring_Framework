package com.dest;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class practice extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		String name = req.getParameter("name");
		String address = req.getParameter("address");

		PrintWriter pw = resp.getWriter();

		Date date = new Date();

		String htmlResp = " <html>" + "<body>" + "<h1> The Destination Current Date and Time Is  :</h1> "
				+ "<font color=\"red\"> " + date + "</font> </br> " + "<h2> The Name Is : " + name + "</h2>"
				+ "<h2> The Address Is : " + address + "</h2>" + "</body>" + " </html>";
		pw.println(htmlResp);

		
	}
	
	
}
