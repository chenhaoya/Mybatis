package com.ch.dao;

import com.ch.pojo.User;
import com.ch.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest{
    @Test
    public void testUserAll() {
        /*获得SqlSession对象*/
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            /*执行SQL*/
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
            System.out.println("============================");
            //方式二：
            List<User> objects = sqlSession.selectList("com.ch.dao.UserMapper.getUserList");
            for (User object : objects) {
                System.out.println(object);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*关闭SqlSession*/
            sqlSession.close();
        }
    }
    @Test
    public void testSelectUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = null;
        sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(4, "12213", "2222"));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(4);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(2, "修改", "修改"));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userId",6);
        map.put("userName","MAP");
        map.put("passWord","Map");
        int i = mapper.addUser2(map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("helloid","2");
        map.put("name","修改");
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}