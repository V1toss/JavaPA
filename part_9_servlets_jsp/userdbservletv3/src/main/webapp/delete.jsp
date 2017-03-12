<%--
  User: Karetko Victor
  Date: 12.03.2017
  Time: 21:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<h4>Are you really want to delete user "<%=request.getParameter("login")%>"?</h4>
<form action='<%=request.getContextPath()%>/delete' method=post>
    <input type='hidden' name='login' value='<%=request.getParameter("login")%>'/><br/>
    <input type='submit' value='Delete'/><br/>
</form>
</body>
</html>
