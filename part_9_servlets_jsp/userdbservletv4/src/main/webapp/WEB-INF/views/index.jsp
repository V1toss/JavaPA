<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 15:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Store</title>
</head>
<body>
<h3>List of users</h3>
<table border='1'>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>Create date</th>
    </tr>
        <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.createDate}"/></td>
        <td><a href="${pageContext.servletContext.contextPath}/delete?login=${user.login}">Delete</a></td>
        <td><a href="${pageContext.servletContext.contextPath}/update?login=${user.login}">Update</a></td>
    </tr>
   </c:forEach>
</table>
<br/>
    <a href="${pageContext.servletContext.contextPath}/create">Add new user</a>

</body>
</html>
