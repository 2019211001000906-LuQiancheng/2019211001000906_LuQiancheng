package com.luqiancheng.week3;

import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet(value = "/jdbc")
public class RegisterServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String birthdate = request.getParameter("date");
        User user = new User(name, password, email, gender, birthdate);


        PreparedStatement preparedStatement = null;
        String sql = "insert into userdb.usertable(username,password,email,gender,birthdate) values(?,?,?,?,?);";
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getGender());
            preparedStatement.setString(5,user.getBirthdate());
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String sql1 = "select * from userdb.usertable;";
//        ResultSet resultset = null;
//        PrintWriter pw = response.getWriter();
//
//        try {
//            preparedStatement = connection.prepareStatement(sql1);
//            resultset = preparedStatement.executeQuery();
//
//            pw.print("<table border ='1'>");
//
//            pw.print("<tr>");
//            pw.print("<td>ID</td>");
//            pw.print("<td>username</td>");
//            pw.print("<td>password</td>");
//            pw.print("<td>email</td>");
//            pw.print("<td>gender</td>");
//            pw.print("<td>birthdate</td>");
//            pw.print("</tr>");
//            while(resultset.next()){
//                pw.print("<tr>");
//                pw.print("<td>"+resultset.getInt("id")+"</td>");
//                pw.print("<td>"+resultset.getString("username")+"</td>");
//                pw.print("<td>"+resultset.getString("password")+"</td>");
//                pw.print("<td>"+resultset.getString("email")+"</td>");
//                pw.print("<td>"+resultset.getString("gender")+"</td>");
//                pw.print("<td>"+resultset.getString("birthdate")+"</td>");
//                pw.print("</tr>");
//            }
//            pw.print("</table>");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
//            resultset.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
