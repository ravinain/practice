<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="/fetchEmp">
		<s:textfield label="Employee ID" name="id"></s:textfield>
		<s:textfield label="Name" name="name"></s:textfield>
		<s:textfield label="Age" name="age"></s:textfield>
		<s:textfield label="Salary" name="salary"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>