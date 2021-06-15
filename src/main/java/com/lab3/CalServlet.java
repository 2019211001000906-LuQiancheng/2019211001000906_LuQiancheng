package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {
    public int add(int firstVal,int secondVal){
        return firstVal+secondVal;
    }
    public int subtract(int firstVal,int secondVal){
        return firstVal-secondVal;
    }
    public int multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }
    public int divide(int firstVal,int secondVal){
        return firstVal/secondVal;
    }
    public int computeLength(String string){
        return string.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal = request.getParameter("firstVal")!=null?Integer.parseInt(request.getParameter("firstVal")):0;
        int secondVal = request.getParameter("secondVal")!=null?Integer.parseInt(request.getParameter("secondVal")):0;
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        int result=0;
        int length=0;
        if (action.equals("add")){
            result = add(firstVal,secondVal);
        }else if (action.equals("subtract")){
            result = subtract(firstVal,secondVal);
        }else if (action.equals("multiply")){
            result = multiply(firstVal,secondVal);
        }else if (action.equals("divide")){
            result = divide(firstVal,secondVal);
        }else if (action.equals("computeLength")){
            length = computeLength(name);
        }else {
            request.getRequestDispatcher(request.getContextPath()+"/lab3/cal.jsp").forward(request,response);
        }
        if (action.equals("add")||action.equals("subtract")||action.equals("multiply")||action.equals("divide")){
            Cookie cFirstVal = new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondVal = new Cookie("cSecondVal", String.valueOf(secondVal));
            Cookie cResult = new Cookie("cResult", String.valueOf(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
        }
        if (action.equals("computeLength")){
            Cookie cName = new Cookie("cName", name);
            Cookie cLength = new Cookie("cLength", String.valueOf(length));

            cName.setMaxAge(5);
            cLength.setMaxAge(5);

            response.addCookie(cName);
            response.addCookie(cLength);
        }
        response.sendRedirect(request.getContextPath()+"/lab3/cal.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
