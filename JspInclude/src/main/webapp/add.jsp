<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
int x,y;
%>
<%
x = Integer.parseInt(request.getParameter("n1"));
y = Integer.parseInt(request.getParameter("n2"));
%>
<%= x+y %>
</body>
</html>