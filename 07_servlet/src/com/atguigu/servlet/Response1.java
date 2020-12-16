package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    请求重定向的特点：
    1.浏览器地址会发生变化
    2.是两次请求
    3.不共享resquest数据
    4.不能访问WEB-INF下的资源
    5.可以访问工程外的目录

 */

public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1 ");
         System.out.println("曾到此一游 ");
        req.setAttribute("key1", "value1");

        // 设置响应状态码302 ，表示重定向，（已搬迁）
//        resp.setStatus(302);
        // 设置响应头，说明 新的地址在哪里
//        resp.setHeader("Location", "http://localhost:8080/07_servlet/response2");
//        resp.setHeader("Location", "http://localhost:8080");

        resp.sendRedirect("http://localhost:8080");
    }
}
