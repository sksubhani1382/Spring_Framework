package com.dest;

import java.io.*;
import javax.servlet.*;

public class GenericservletExp extends GenericServlet

{
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>My first Servlet</title></head>");
		pw.println("<body>");
		pw.println("<h2>Welcome To Servlet World!</h2>");
		pw.println("<form action=http://localhost:8080/StudentApp1/stuDetails   method=POST>");
		pw.println("Id: <input type=number name=id><br><br>");
		pw.println("password: <input type=password name=password><br><br>");
		pw.println("<input type=submit value=login>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
