<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Vitoss
  Date: 31.03.2017
  Time: 0:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
</head>
<body>
<h3>List of roles</h3>
<table border='1'>
    <tr>
        <th>Id</th>
        <th>Role</th>
        <th></th>
    </tr>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><c:out value="${role.id}"/></td>
            <td><c:out value="${role.name}"/></td>
            <c:if test="${role.name!='admin'}">
               <td><a href="${pageContext.servletContext.contextPath}/delrole?id=${role.id}">Delete</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${pageContext.servletContext.contextPath}/addrole">Add new role</a>
</body>
</html>
