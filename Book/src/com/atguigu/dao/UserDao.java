package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * @author Dutlgy
 * @create 2020-12-16-19:37
 */
public interface UserDao {





    /**
     * @param: username
     * @return : 如果返回null，则没有用户
     * @throws :
     * @author : LGY
     * @description : 根据用户名查询用户信息
     * @date : 2020/12/16 19:40
     */

    public User queryUserByUsername(String username);

    /**
     * @param: user
     * @return :
     * @throws :
     * @author : LGY
     * @description : 用户注册功能
     * @date : 2020/12/16 19:43
     */

    public int insertUser(User user);

    /**
     * @param: username
     * @param: password
     * @return : 
     * @throws :
     * @author : LGY
     * @description :
     * @date : 2020/12/16 19:46
     */
    
    public User queryUserByUsernameAndPassword(String username,String password);



}
