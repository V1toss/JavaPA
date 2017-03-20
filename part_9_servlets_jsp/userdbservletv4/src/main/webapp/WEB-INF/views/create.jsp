<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 21:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<h4>Create User</h4>
<form action='${pageContext.servletContext.contextPath}/create' method=post>
Login: <input type='text' name='login'><br/>
Name: <input type='text' name='name'><br/>
Email: <input type='text' name='email'><br/>
<input type='submit' value='Create'/>
</form>
</body>
</html>
