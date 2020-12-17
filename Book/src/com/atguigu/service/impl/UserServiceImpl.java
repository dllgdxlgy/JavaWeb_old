package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

/**
 * @author Dutlgy
 * @create 2020-12-17-8:18
 */
public class UserServiceImpl implements UserService {

    //创建UserDao是为了调用dao层
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.insertUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
