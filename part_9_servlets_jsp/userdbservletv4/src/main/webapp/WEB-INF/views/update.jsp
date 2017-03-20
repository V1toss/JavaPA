<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 21:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h4>Update User</h4>

<form action='${pageContext.servletContext.contextPath}/update' method=post>
Login: <input type='text' name='login' value='${user.login}'>    <br/>
Name: <input type='text' name='name' value='${user.name}'>    <br/>
Email: <input type='text' name='email' value='${user.email}'>    <br/>
<input type='submit' value='Update'/>
    <br/>
 </form>
</body>
</html>
