package com.luqiancheng.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
//        String driver = getServletConfig().getServletContext().getInitParameter("driver");
//        String url = getServletConfig().getServletContext().getInitParameter("url");
//        String username = getServletConfig().getServletContext().getInitParameter("username");
//        String password = getServletConfig().getServletContext().getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            this.connection = DriverManager.getConnection(url,username,password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(this.connection != null){
//            System.out.println("连接成功数据库了！");
//        }else{
//            System.out.println("连接失败了！");
//        }
       connection = (Connection) getServletContext().getAttribute("connection");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        String sql ="select * from userdb.usertable where username = ? and password = ?;";
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultset = preparedStatement.executeQuery();
            if (resultset.next()){
               request.setAttribute("id",resultset.getInt("id"));
               request.setAttribute("username",resultset.getString("username"));
               request.setAttribute("password",resultset.getString("password"));
               request.setAttribute("email",resultset.getString("email"));
               request.setAttribute("gender",resultset.getString("gender"));
               request.setAttribute("birthdate",resultset.getString("birthdate"));
               request.getRequestDispatcher("/userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","UserName OR Password Error!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
