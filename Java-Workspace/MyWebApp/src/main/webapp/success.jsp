<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<% String name=(String)request.getAttribute("myname"); %>
<% List<String> list=new ArrayList<>(); %>
<%=name %>
<%=application.getAttribute("myname") %>
<%=config.getInitParameter("myname") %>
<h2> authentication successful </h2>
<h2>welcome <%=session.getAttribute("uname") %></h2>
</body>

</html>