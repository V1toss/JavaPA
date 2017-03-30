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
        <c:if test="${user.role.name=='admin'}">
            <th>Roles</th>
        </c:if>
        <th></th>
    </tr>
        <c:forEach items="${users}" var="el">
    <tr>
        <td><c:out value="${el.name}"/></td>
        <td><c:out value="${el.login}"/></td>
        <td><c:out value="${el.email}"/></td>
        <td><c:out value="${el.createDate}"/></td>
        <c:if test="${user.role.name=='admin'}">
            <td><c:out value="${el.role.name}"/></td>
            <td><a href="${pageContext.servletContext.contextPath}/delete?login=${el.login}">Delete</a></td>
            <td><a href="${pageContext.servletContext.contextPath}/update?login=${el.login}">Update</a></td>
        </c:if>
        <c:if test="${user.role.name!='admin'}">
            <c:if test="${el.login == user.login}">
                <td><a href="${pageContext.servletContext.contextPath}/update?login=${el.login}">Update</a></td>
            </c:if>
        </c:if>
    </tr>
   </c:forEach>
</table>
<br/>
<c:if test="${user.role.name=='admin'}">
    <a href="${pageContext.servletContext.contextPath}/create">Add new user</a>
    <a href="${pageContext.servletContext.contextPath}/edit_roles">Edit roles</a>
</c:if>
</body>
</html>
