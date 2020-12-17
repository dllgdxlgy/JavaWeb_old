package com.atguigu.servlet;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dutlgy
 * @create 2020-12-17-12:27
 */
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user = userService.login(new User(null,username,password,null));

        if(user!=null){
            System.out.println("用户名:"+user.getUsername()+"登录");
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }else{
            System.out.println("用户名"+username+"不存在");
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }



    }
}
