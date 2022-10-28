<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row" style="height: 100vh;">
		<div class="col-6">
			<img alt="" src="img/AKIT-new.png">
		</div>
		<div class="col-6">
			<form action="login" method="get">
				<div>
					<span>EmpName</span><input type="text" name="empName">
				</div>
				<div>
					<span>Password</span><input type="password" name="password">
				</div>
				<div>
					<span>Admin </span>
					<input type="checkbox" value="Admin" name="role">
				</div>
				<div>
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>