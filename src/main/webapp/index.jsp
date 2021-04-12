<%--
  Created by IntelliJ IDEA.
  User: ytyt
  Date: 2021/3/10
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<body>
<%@include file="header.jsp" %>
<h2>Hello World!</h2>


<h2><a href="${pageContext.request.contextPath}/homeWork1">homeWork1</a></h2>
<h2><a href="${pageContext.request.contextPath}/register.jsp">register</a></h2>
<h2><a href="${pageContext.request.contextPath}/config">config</a></h2>
<h2><a href="${pageContext.request.contextPath}/login.jsp">login</a></h2>

<form action="${pageContext.request.contextPath}/search" method="get">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>

<%@include file="footer.jsp"%>

</body>
</html>
