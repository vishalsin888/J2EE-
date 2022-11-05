<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>function tags</h1>
<c:set var="test" value="This Is A">
</c:set>

<c:out value="${fn:toLowerCase(test)}" />
<br>
<c:out value="${fn:replace(test,' ','')}" />
<br>
<c:out value="${fn:containsIgnoreCase(test,'a')}" />
<br>
<c:out value="${fn:startsWith(test,'Th')}" />


</body>

</html>