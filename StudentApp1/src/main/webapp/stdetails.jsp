<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/StudentApp1/stuDetails" method=POST>
		Id: <input type="number" name="id"><br><br>
		Password: <input type="password" name="password"><br><br>
		<input type="submit" value="login">
	</form>
	
<%
	int id=Integer.parseInt(request.getParameter("id"));
	String password=request.getParameter("password");
%>
</body>
</html>