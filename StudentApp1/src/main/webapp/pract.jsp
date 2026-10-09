<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>THe name and address: </h1>
	<%
	Date date=new Date();
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	%>
	<%= date %>
	<p>The name is:<%=name%> </p>
	<p>The address is:<%=address%></p>

</body>
</html>