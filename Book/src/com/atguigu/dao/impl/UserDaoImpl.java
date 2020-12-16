package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;





/**
 * @author Dutlgy
 * @create 2020-12-16-19:46
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`email`from t_user where username = ?";

        return queryForOne(User.class,sql,username);
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values (?,?,?)";

        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {

        String sql = "select `id`, `username`,`password`,'email' from t_user where username = ? and password = ?";

        return queryForOne(User.class,sql,username,password);

    }
}
