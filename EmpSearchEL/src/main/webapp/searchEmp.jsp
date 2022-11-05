<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
String name;
%>
<%
name = request.getParameter("ename");
%>
Name Entered is  <%= name %>

Name Entered is ${param.ename }
</body>
</html>