<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<%--this is counter mechanism --%>
<%!
int counter=0;
List<String> list=new ArrayList<>();
public String sayHello(String name){
	return "welcome "+name;
}
%>

<%
counter++;

%>
<h2>you are visitor number <%=counter %></h2>
<%=sayHello("rashmi") %>
</body>
</html>