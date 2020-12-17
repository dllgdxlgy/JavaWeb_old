package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * @author Dutlgy
 * @create 2020-12-17-8:12
 */
public interface UserService {

    /**
     * @param: user
     * @return :
     * @throws :
     * @author : LGY
     * @description : 注册用户
     * @date : 2020/12/17 8:13
     */

    public void registUser(User user);

    /**
     * @param: user
     * @return :
     * @throws :
     * @author : LGY
     * @description : 登陆业务
     * @date : 2020/12/17 8:14
     */

    public User login(User user);

    /**
     * @param: username
     * @return : 返回 true 表示用户名已存在， 返回 false 表示用户名可用
     * @throws :
     * @author : LGY
     * @description : 检查用户名是否可用
     * @date : 2020/12/17 8:16
     */

    public boolean existsUsername(String username);
}
