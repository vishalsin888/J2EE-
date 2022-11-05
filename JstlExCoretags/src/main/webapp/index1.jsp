<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
taglib<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Core tags</h1>
<c:set var="num1" value="100"></c:set>
<c:set var="num2" value="20"></c:set>
<%-- before remove <c:out value="${num1 }"></c:out>
<c:remove var="num1"/>
after remove <c:out value="${num1 }"></c:out> --%>
<c:out value="${num1 }"></c:out>
<c:out value="${num2 }"></c:out>
<c:if test="${num1 == '100'}">
<h1> <c:out value="${num1 }"></c:out> is greater than <c:out value="${num2 }"></c:out></h1>
</c:if>
<c:forEach var="i" begin="0" end="10">           for( int i=0;i<10;i++){}
<h1>value is <c:out value="${i }"></c:out></h1>
</c:forEach>

<c:forEach var="data" items="arr">
<c:out value=""></c:out>
</c:forEach>

<c:choose>
<c:when test="">

</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>


 <%-- <c:set var="url" value="2"/>  
  <c:if test="${url<1}">  
     <c:redirect url="https://www.google.co.in/"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="https://in.search.yahoo.com/"/>  
  </c:if> --%>
  
<c:forTokens var="str" items="This is a" delims=" ">
	<h1><c:out value="${str }" /></h1>
</c:forTokens>
 
 
</body>

</html>