package com.luqiancheng.week2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Register2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String msg;
        if (!email.equals("")){
            if (email.contains("@")){

                msg = "OK";
            }else {
                msg = "* ERROR : Email format is not correct !";
            }

        }else {
            msg = "* ERROR : Email is NULL !";
        }
        response.getWriter().write(msg);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
