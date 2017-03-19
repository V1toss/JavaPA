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

<form action='<%=request.getContextPath()%>/update' method=post>
Login: <input type='text' name='login' value='<%=request.getParameter("login")%>'>
    <br/>
Name: <input type='text' name='name' value='<%=request.getParameter("name")%>'>
    <br/>
Email: <input type='text' name='email' value='<%=request.getParameter("email")%>'>
    <br/>
<input type='submit' value='Update'/>
    <br/>
 </form>
</body>
</html>
