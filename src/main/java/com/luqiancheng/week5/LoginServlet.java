package com.luqiancheng.week5;

import com.luqiancheng.dao.UserDao;
import com.luqiancheng.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        super.init();
       connection = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(connection, username, password);

            if (user!=null){

                String rememberMeVale = request.getParameter("rememberMeVale");
                if (rememberMeVale!=null && rememberMeVale.equals("1")){


                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberMeVale);


                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }

                //valid
                //week 8 code
                //create a session
                HttpSession session = request.getSession();
                System.out.println("Session id----->"+session.getId());

                session.setMaxInactiveInterval(15);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","UserName OR Password Error!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        PreparedStatement preparedStatement = null;
//        ResultSet resultset = null;
//        String sql ="select * from userdb.usertable where username = ? and password = ?;";
//        try {
//            preparedStatement = this.connection.prepareStatement(sql);
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2,password);
//            resultset = preparedStatement.executeQuery();
//            if (resultset.next()){
//               request.setAttribute("id",resultset.getInt("id"));
//               request.setAttribute("username",resultset.getString("username"));
//               request.setAttribute("password",resultset.getString("password"));
//               request.setAttribute("email",resultset.getString("email"));
//               request.setAttribute("gender",resultset.getString("gender"));
//               request.setAttribute("birthdate",resultset.getString("birthdate"));
//               request.getRequestDispatcher("/userinfo.jsp").forward(request,response);
//            }else {
//                request.setAttribute("msg","UserName OR Password Error!");
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
