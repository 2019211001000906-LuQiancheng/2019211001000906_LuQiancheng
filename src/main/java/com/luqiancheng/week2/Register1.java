package com.luqiancheng.week2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Register1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String password = request.getParameter("password");
        String msg;
        if (!password.equals("")){
            if (password.length() >= 8) {
                msg = "OK";
            } else {
                msg = "* ERROR : The password length is less than eight !";
            }
        } else {
            msg = "* ERROR : password is NULL !";
        }
        response.getWriter().write(msg);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
