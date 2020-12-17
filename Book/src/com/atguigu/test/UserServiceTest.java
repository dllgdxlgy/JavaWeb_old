package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dutlgy
 * @create 2020-12-17-8:32
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"lgyyy","123","dlutlgy@163.com"));
    }

    @Test
    public void login() {
        User user = new User();
        user.setUsername("lgy");
        user.setPassword("123");
        System.out.println(userService.login(user));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("lgy")){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }
    }
}