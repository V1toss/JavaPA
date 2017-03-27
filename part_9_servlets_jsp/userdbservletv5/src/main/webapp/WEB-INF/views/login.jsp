<%--
  User: Karetko Viktor
  Date: 27.03.2017
  Time: 15:20
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<c:if test="${error !=''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action='${pageContext.servletContext.contextPath}/signin' method=post>
    Login: <input type='text' name='login'><br/>
    Password: <input type='password' name='password'><br/>
    <input type='submit'/>
</form>
</body>
</html>
