<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
   <h1>Employee Registration Form</h1>
   <a href="changeLocale.htm?lang=en">English</a>
   <a href="changeLocale.htm?lang=es">Spanish</a>
   <!--<form method="POST" action="saveemp.htm">
		<br/>
		ID: <input type="text" name="eid"/> <br/>
		FirstName: <input type="text" name="fname"/> <br/>
		LastName: <input type="text" name="lname"/> <br/>
		<input type="submit" value="Save Employee"/> <br/>
</form>-->
<f:form method="POST" action="saveemp.htm" modelAttribute="emp">
   <s:message code="emp.id"></s:message> <f:input path="eid"/><f:errors path="eid"></f:errors>
   <s:message code="emp.fname"></s:message><f:input path="fname"/><f:errors path="fname"></f:errors>
   <s:message code="emp.lname"></s:message><f:input path="lname"/><f:errors path="lname"></f:errors>
   <input type="submit" value="submit">
</f:form>
</body>
</html>