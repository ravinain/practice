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

	<s:form action="/fetchUser">
		<s:textfield name="user.name" label="Name"></s:textfield>
		<s:textfield name="user.age" label="Age"></s:textfield>
		<s:textfield name="user.id" label="Id"></s:textfield>
		<s:submit></s:submit>
	</s:form>

</body>
</html>