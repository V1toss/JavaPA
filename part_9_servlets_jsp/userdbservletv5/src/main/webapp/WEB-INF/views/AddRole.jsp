<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 21:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add role</title>
</head>
<body>
<h4>Create User</h4>
<form action='${pageContext.servletContext.contextPath}/addrole' method=post>
Role: <input type='text' name='role'><br/>
<input type='submit' value='Create'/>
</form>
</body>
</html>
