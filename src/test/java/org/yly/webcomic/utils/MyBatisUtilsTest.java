package org.yly.webcomic.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBatisUtilsTest {

    @Test
    void testConnection(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.sqlSessionFactory;
        System.out.println(sqlSessionFactory.openSession());
    }

}