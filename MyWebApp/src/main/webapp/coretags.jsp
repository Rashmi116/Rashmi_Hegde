<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://com.wileyedge.hello" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tags</title>
</head>
<body>
  <c:out value="welcome to standard tags"></c:out>
  <br>
  <c:set var="salary" scope="session" value="${4000*12}"></c:set>
  <c:set var="salary" scope="request" value="${3000*12}"></c:set>
  <c:out value="${requestScope.salary}">
</c:out>
<c:out value="${sessionScope.salary}">
</c:out>
<br>
<c:remove var="salary" scope="request"/> 
<br>
After removal of value : <c:out value="${salary}"/>
<br>
<c:catch var ="myException">  
   <% int x = 2/0;%>  
</c:catch>
<c:if test="${myException != null}">  
   <p>The type of exception is : ${myException} <br />  
   There is an exception: ${myException.message}</p>  
</c:if>

<c:forEach begin="1" end="10" step="2"  var="myValue">
	<c:out value="${myValue}"></c:out>
</c:forEach>

<h:hello name="rashmi"></h:hello>
<h:hello name="tommy"></h:hello>
</body>
</html>