<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<ul>
		<li><s:a href="beverage/coffee">Coffee</s:a></li>
		<li><s:a href="beverage/tea">Tea</s:a></li>
		<li><s:a href="beverage/milk">Milk</s:a></li>
		<li><s:a href="beverage">Unknown</s:a></li>
	</ul>
</body>
</html>