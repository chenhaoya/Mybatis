/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/1/21 17:35
 * 开发名称：MybatisUtils
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**sqlSessionFactory--->sqlSession*/
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    /*使用mybatis的第一步：获取sqlSessionFactory对象*/
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。*/
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}