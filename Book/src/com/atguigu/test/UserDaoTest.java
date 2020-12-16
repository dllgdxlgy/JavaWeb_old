package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Dutlgy
 * @create 2020-12-16-20:02
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println( userDao.queryUserByUsername("admin"));
    }

    @Test
    public void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("lgy");
        user.setPassword("123");
        user.setEmail("dlutlgy@126.com");
        System.out.println(userDao.insertUser(user));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        String username = "lgy";
        String password = "123";
        System.out.println(userDao.queryUserByUsernameAndPassword(username,password));
    }
}