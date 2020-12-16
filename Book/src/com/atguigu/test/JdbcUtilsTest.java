package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

/**
 * @author Dutlgy
 * @create 2020-12-16-14:42
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtilsTest(){
        for (int i = 0; i<100 ; i++){
            System.out.println(JdbcUtils.getConnection());

        }


    }
}
