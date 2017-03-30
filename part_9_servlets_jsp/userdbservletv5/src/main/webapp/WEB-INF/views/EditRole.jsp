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
   </tr>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><c:out value="${role.id}"/></td>
            <td><c:out value="${role.name}"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>
