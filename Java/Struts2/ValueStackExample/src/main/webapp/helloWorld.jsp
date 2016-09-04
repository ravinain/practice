<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   Entered value : <s:property value="name"/><br/>
   Value of key 1 : <s:property value="key1" /><br/>
   Value of key 2 : <s:property value="key2" /> <br/>
   
   You cannot access key3 and key4 without # literal. <br />
   Value of key 3 : <s:property value="#request.key3"/> <br />
   Value of key 4 : <s:property value="#session.key4"/> <br />
</body>
</html>