
<%@page import="java.sql.*" isErrorPage="false" errorPage="err.jsp" session="true"%>
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

public static String URL = "jdbc:mysql://localhost:3306/dbtest";
public static String USER = "root";
public static String PASSWORD = "root";
Connection conn;
PreparedStatement pst;
ResultSet rs;
String query = "Select * from users where empname like ?";
public void jspInit(){
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL,USER,PASSWORD);
	}catch(Exception e){
		
	}
}
%>
<%
String name = request.getParameter("empname");
session.setAttribute("empname",name);
pst = conn.prepareStatement(query);
pst.setString(1, name);
//int a = 10/0;
rs = pst.executeQuery();
boolean resp = rs.next();
if(resp){
	out.println("Hii "+name);
%>
<h2>  EmpName : <%= rs.getString(1) %></h2>
<h2>  Email : <%= rs.getString(2) %></h2>
<h2>  Password : <%= rs.getString(3) %></h2>
<h2>  Role : <%= rs.getString(4) %></h2>
<%
}else{
%>
<h2><%= name %> Not Found</h2>
<%
}
%>

</body>
</html>