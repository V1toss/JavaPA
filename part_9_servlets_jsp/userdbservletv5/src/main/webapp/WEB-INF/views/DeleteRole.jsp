<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 21:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete role</title>
</head>
<body>
<form action='${pageContext.servletContext.contextPath}/delrole' method=post>
    <h4>Are you really want to delete role ${role.name}?</h4>
    <input type='hidden' name='id' value='${role.id}'/><br/>
    <input type='submit' value='Delete'/><br/>
</form>
</body>
</html>
