//package com.luqiancheng.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "AdminAuthenticationFilter",value = "/admin/*")
//public class AdminAuthenticationFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpServletResponse httpResponse = (HttpServletResponse) resp;
//        HttpSession session = httpRequest.getSession(false);
//        boolean isloggedIn = (session != null && session.getAttribute("userList")!=null);
//        String loginURI = httpRequest.getContextPath() + "/admin/login";
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
//        if (isloggedIn &&(isLoginRequest || isLoginPage)){
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/home");
//            dispatcher.forward(req,resp);
//        }else if (isloggedIn || isLoginRequest){
//            chain.doFilter(req, resp);
//        }else {
//            httpResponse.sendRedirect(httpRequest.getContextPath()+"/admin/login");
//        }
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
