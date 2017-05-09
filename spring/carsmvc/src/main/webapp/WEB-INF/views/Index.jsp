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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <h3 style="text-align: center">List of orders</h3>
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead style="background: blue">
                <tr style="color: white">
                    <th>Car brand</th>
                    <th>Car model</th>
                    <th>Color</th>
                    <th>Year</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Create date</th>
                    <th>User</th>
                    <th>Sold</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="el">
                    <tr>
                        <td><c:out value="${el.car.model.brand.name}"/></td>
                        <td><c:out value="${el.car.model.name}"/></td>
                        <td><c:out value="${el.car.color}"/></td>
                        <td><c:out value="${el.car.year}"/></td>
                        <td><c:out value="${el.description}"/></td>
                        <td><c:out value="${el.price}"/></td>
                        <td><c:out value="${el.date}"/></td>
                        <td><c:out value="${el.user.login}"/></td>
                        <td><c:out value="${el.sold}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
