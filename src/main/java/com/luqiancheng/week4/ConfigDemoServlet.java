package com.luqiancheng.week4;

import javax.naming.Name;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/config",loadOnStartup = 1,initParams = {@WebInitParam(name = "name",value = "Lu Qiancheng"),@WebInitParam(name = "StudentID",value = "2019211001000906")})
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();
        String name = servletConfig.getInitParameter("name");
        String studentID = servletConfig.getInitParameter("StudentID");

        PrintWriter pw = resp.getWriter();
        pw.print("<h1>Name :"+name+"</h1>");
        pw.print("<h1>ID : "+studentID+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
