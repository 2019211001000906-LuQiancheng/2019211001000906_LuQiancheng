package com.luqiancheng.controller;

import com.luqiancheng.dao.ProductDao;
import com.luqiancheng.model.Category;
import com.luqiancheng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    private Connection con = null;

    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ProductDao productDao = new ProductDao();
        List<Product> productList = null;
        try {
            if (request.getParameter("categoryId")==null){
                productList = productDao.findAll(con);
            }else {
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryId,con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productList",productList);
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }
}
