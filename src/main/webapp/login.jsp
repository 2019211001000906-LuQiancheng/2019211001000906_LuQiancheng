<%--
  Created by IntelliJ IDEA.
  User: ytyt
  Date: 2021/3/31
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>


<form action="${pageContext.request.contextPath}/login" method="post">
    <h1>Login</h1>
    UserName:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
    <span style="color: red">${requestScope.msg}</span>
</form>



<%@include file="footer.jsp" %>
</body>
</html>
