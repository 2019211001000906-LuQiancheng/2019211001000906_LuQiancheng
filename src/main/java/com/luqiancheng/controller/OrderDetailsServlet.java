package com.luqiancheng.controller;

import com.luqiancheng.dao.OrderDao;
import com.luqiancheng.model.Item;
import com.luqiancheng.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet",value = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con = null;

    public void init(){
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item = new Item();
        OrderDao dao = new OrderDao();
        List<Item> itemList = dao.findItemsByOrderId(con, orderId);
        request.setAttribute("itemList",itemList);
        System.out.println(itemList);
        String path = "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
