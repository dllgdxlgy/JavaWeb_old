package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //这里是不能进行打印的，也就是说不会共享Resquest对象数据
        System.out.println(req.getAttribute("key1"));

        resp.getWriter().write("response2's result!");
    }
}
