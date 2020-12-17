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
 * @create 2020-12-17-8:59
 */
public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

        //1.获取请求参数
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确，由服务器生成。这里写死检查。验证码：abcd
        if("abcd".equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                System.out.println("用户名"+username+"不可用");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);

            }else {
                System.out.println("用户名可用");
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码错误，输入的是："+code);
            /* 请求转发必须/开头，根据路径/表示在工程路径下，所以是/pages/user/regist_success.html*/
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }

    }
}
