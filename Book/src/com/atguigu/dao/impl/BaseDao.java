package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Dutlgy
 * @create 2020-12-16-15:55
 */
public abstract class BaseDao {
    //使用 DbUtils 操作数据库 commons-dbutils-1.3.jar

    private QueryRunner queryRunner = new QueryRunner();



    /**
     * @param: sql
     * @param: args
     * @return 如果返回-1，说明执行失败，其他表示影响的行数
     * @throws
     * @author : LGY
     * @description update() 方法用来执行 insert \ update \ delete 语句
     * @date : 2020/12/16 17:02
     */
    public int update(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    //查询一条或者返回一个javabean 的sql语句
    
   

    /**
     * @param: type 返回对象的类型
     * @param: sql 执行的sql语句
     * @param: args sql对应的参数值
     * @return java.lang.Object
     * @throws
     * @author : LGY
     * @description TODO
     * @date : 2020/12/16 17:03
     */
    public <T> T queryForOne(Class<T> type, String sql,Object ... args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return  queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * @param: type
     * @param: sql
     * @param: args
     * @return java.util.List<T>
     * @throws
     * @author : LGY
     * @description 查询返回list
     * @date : 2020/12/16 19:30
     */
    public <T>List<T>queryForList(Class<T> type, String sql,Object ... args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return  queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * @param: sql
     * @param: args
     * @return java.lang.Object
     * @throws
     * @author : LGY
     * @description TODO
     * @date : 2020/12/16 19:35
     */
    public Object queryForSingleValue(String sql, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

}
