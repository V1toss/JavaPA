<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Karetko Victor
  Date: 09.05.2017
  Time: 15:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h3>List of orders</h3>
<table border='1'>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Year</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${orders}" var="el">
        <tr>
            <td><c:out value="${el.car.model.brand.name}"/></td>
            <td><c:out value="${el.car.model.name}"/></td>
            <td><c:out value="${el.car.year}"/></td>
            <td><c:out value="${el.description}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
