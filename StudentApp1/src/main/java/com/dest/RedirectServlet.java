package com.dest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		String item = req.getParameter("uwant");
		// String encodedItem = URLEncoder.encode(item,
		// StandardCharsets.UTF_8.toString());

		String url = "https://www.amazon.in/s?k=" + item;
		resp.sendRedirect(url);
	}
}