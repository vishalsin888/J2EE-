<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<h2 style="color: red"> This is Error Page </h2>
<h3>Searching for <%= session.getAttribute("empname") %></h3>
</body>
</html>