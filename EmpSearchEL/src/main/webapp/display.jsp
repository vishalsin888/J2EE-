<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Details are :</h2>
<p> EmpName : ${requestScope.empname }</p>
<p> Email : ${requestScope.email }</p>
<p> Password : ${sessionScope.password }</p>
<p> Role : ${sessionScope.role }</p>
</body>
</html>