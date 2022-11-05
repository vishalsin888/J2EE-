<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>sql tags</h1>
	<sql:setDataSource var="dbConn" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/dbtest" user="root" password="root" />

	connection :
	<c:out value="${dbConn}" />
	
	<sql:update var="insCount" dataSource="${dbConn}">
		Insert into users values('abcd','e@e','11111','DB')
	</sql:update>
	
	<c:if test="${insCount > 0}">
		<h2><c:out value="${insCount }" /> row inserted</h2>
	</c:if>
	

	<sql:query var="resSet" dataSource="${dbConn}">
		SELECT * from users
	</sql:query>
	<table border="2" cellpadding = "5" cellspacing = "5">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
			<c:forEach var="item" items="${resSet.rows}">
				<tr>
					<td>${item.empname }</td>
					<td>${item.email }</td>
					<td>${item.password }</td>
					<td>${item.role }</td>
				</tr>
			</c:forEach>
	</table>
</body>

</html>