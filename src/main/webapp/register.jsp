<%--
  Created by IntelliJ IDEA.
  User: ytyt
  Date: 2021/3/10
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <style>
        h3{
            margin: 10px 0px;
        }
        .login1 {
            position: absolute;
            width: 100%;
            background-color:  rgb(161, 160, 160);
        }
        .login2 {
            position: absolute;
            width: 322px;
            height: 421px;
            top: 120px;
            left: 39%;
        }
        .login2 input {
            width: 300px;
            border: none;
            color: #aaa;
            background-color: rgb(229, 230, 225);
            font-size: 14px;
            margin: 7px 0px;/*15px*/
            padding: 10px;
            height: 24px;
            vertical-align: middle;
            border-radius: 4px;
        }
        .title1 input {
            width: 74px;
            color: #aaa;
            font-size: 14px;
            height: 24px;
            vertical-align: middle;
        }

        .title {
            color: #aaa;
        }

        .login2 .an {
            height: 40px;
            background-color: burlywood;
            color: white;
        }
        .login2 .an:hover {
            background-color: cadetblue;
        }
        span {
            color: red;
            font-size: 14px;
            height: 20px;
            line-height: 20px;
        }
        .title1 span {
            width: 74px;
            height: 24px;
            font-size: 17px;
            color: black;
        }
    </style>



    <script>
        var c = "1";
        function a() {
            $.post({
                url:"${pageContext.request.contextPath}/register",
                data:{"name":$("#username").val()},
                success:function (data) {
                    console.log(data);
                    if (data.toString() ==='OK'){
                        c = c + "1";
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfo").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
        function a1() {
            $.post({
                url:"${pageContext.request.contextPath}/register1",
                data:{"password":$("#password").val()},
                success:function (data) {
                    console.log(data);
                    if (data.toString() ==='OK'){
                        c = c + "1";
                        $("#pwdInfo").css("color","green");
                    }else {
                        $("#pwdInfo").css("color","red");
                    }
                    $("#pwdInfo").html(data);
                }
            })
        }

        function a2() {
            $.post({
                url:"${pageContext.request.contextPath}/register2",
                data:{"email":$("#Email").val()},
                success:function (data) {
                    console.log(data);
                    if (data.toString() ==='OK'){
                        c = c + "1";
                        $("#EmaInfo").css("color","green");
                    }else {
                        $("#EmaInfo").css("color","red");
                    }
                    $("#EmaInfo").html(data);
                }
            })
        }
        function a3() {
            $.post({
                url:"${pageContext.request.contextPath}/register3",
                data:{"date":$("#date").val()},
                success:function (data) {
                    c = c + "1";
                    console.log(data);
                    if (data.toString() ==='OK'){
                        $("#DateInfo").css("color","green");
                    }else {
                        $("#DateInfo").css("color","red");
                    }
                    $("#DateInfo").html(data);
                }
            })
        }

        function success() {
            var submit = $('#submit');
            if (c.toString() === "11111"){
                submit.removeAttr("disabled");
            }else {
                submit.attr("disabled","disabled");
            }
        }

    </script>

</head>
<body>

<div class="login1">
    <div class="login2">
        <h3 class="title">New User Registration!</h3>
        <form action="#" method="post">
            <input type="text" id="username" onblur="a()" placeholder="username"/> <br/>
            <span id="userInfo"></span> <br/>
            <input type="password" id="password" onblur="a1()" placeholder="password"/> <br/>
            <span id="pwdInfo"></span> <br/>
            <input type="email" id="Email" onblur="a2()" placeholder="Email"> <br/>
            <span id="EmaInfo"></span> <br/>
            <div class="title1">
                <span>Gender</span>
                <input type="radio" name="sex" checked="checked" /> Male
                <input type="radio" name="sex" /> Female
            </div>
            <input type="date" id="date" onblur="a3()" placeholder="Date of Birth(yyyy-mm-dd)"> <br/>
            <span id="DateInfo"></span> <br/>
            <input class="an" type="submit" id="submit" value="Register"/>
        </form>
    </div>
</div>
</body>
</html>
