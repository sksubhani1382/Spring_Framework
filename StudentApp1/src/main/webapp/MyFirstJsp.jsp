<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red">The current Date and Time is: </h1>
	<%
	Date date=new Date();
	String name=request.getParameter("name");
	String address=request.getParameter("address");
	%>
	
	<%= date %><br><br>
	<p>The Name is: <%=name%></p><br>
	<p>The Address is: <%=address%></p>

</body>
</html>