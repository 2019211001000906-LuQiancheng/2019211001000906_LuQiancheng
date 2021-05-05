<%--
  Created by IntelliJ IDEA.
  User: ytyt
  Date: 2021/4/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Update</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>User Update</h1>

<%
    User u = (User) session.getAttribute("user");
%>

<form action="updateUser" method="post">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>" required/> <br/>
    password<input type="text" name="password" value="<%=u.getPassword()%>" minlength="8" required/> <br/>
    Email<input type="email" name="email" value="<%=u.getEmail()%>" required> <br/>
    Gender:<input type="radio" name="gender" value="Male" <%=u.getGender().equalsIgnoreCase("Male") ? "checked":""%> /> Male
    <input type="radio" name="gender" value="Female" <%=u.getGender().equalsIgnoreCase("Female") ? "checked":""%>/> Female
    <br/>
    Date of Birth:<input type="date" name="birthDate" value="<%=u.getBirthdate()%>" required> <br/>
    <input type="submit" value="Save Changes"/>
</form>

<%@include file="footer.jsp"%>

</body>
</html>
