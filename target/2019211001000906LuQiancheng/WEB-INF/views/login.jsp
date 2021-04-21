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

<%
    if (request.getParameter("msg")!=null){
    }
%>

<%
    Cookie[] allCookies = request.getCookies();
    String username = "",password = "",rememberMeVale="";
    if (allCookies!=null){
        //we read 3 cookies
        for (Cookie c : allCookies) {
            //get one by one
            if (c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVale = c.getValue();
            }
        }
    }
%>


<form action="${pageContext.request.contextPath}/login" method="post">
    <h1>Login</h1>
    UserName:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMeVale" value="1" <%=rememberMeVale.equals("1")?"checked":""%>checked/>Remember Me<br/>
    <input type="submit" value="Login">
    <span style="color: red">${requestScope.msg}</span>
</form>



<%@include file="footer.jsp" %>
</body>
</html>
