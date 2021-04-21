<%@ page import="com.luqiancheng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ytyt
  Date: 2021/4/12
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>user info </h1>
<%
User u = (User) session.getAttribute("user");
%>
    <table>
        <tr>
            <td>ID:</td>
            <td><%=u.getId()%></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><%=u.getUsername()%></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><%=u.getPassword()%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=u.getEmail()%></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><%=u.getGender()%></td>
        </tr>
        <tr>
            <td>Birth Date:</td>
            <td><%=u.getBirthdate()%></td>
        </tr>
    </table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp" %>
</body>
</html>
