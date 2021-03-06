<%@ page import="vkaretko.models.User" %>
<%@ page import="vkaretko.DBManager" %>
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
        <%
            for (User user : DBManager.getInstance().getAll(DBManager.getConnection())) {
                String urlDel = String.format("%s/delete.jsp?login=%s", request.getContextPath(), user.getLogin());
                String urlUpd = String.format("%s/update.jsp?login=%s&name=%s&email=%s",
                        request.getContextPath(), user.getLogin(), user.getName(), user.getEmail());
    %>
    <tr>
        <td><%=user.getName()%> </td>
        <td><%=user.getLogin()%> </td>
        <td><%=user.getEmail()%> </td>
        <td><%=user.getCreateDate()%></td>
        <td><a href="<%=urlDel%>">Delete</a></td>
        <td><a href="<%=urlUpd%>">Update</a></td>
    </tr>
        <%}
        %>
</table>
<br/>
    <a href='<%=request.getContextPath()%>/create.jsp'>Add new user</a>

</body>
</html>
