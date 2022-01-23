package com.ch.dao;

import com.ch.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**获取全部查询用户*/
    List<User> getUserList();
    /**根据ID查询用户*/
    User getUserById(int id);
    /**更具ID查询用户改进*/
    User getUserById2(Map<String,Object>map);
    /**增加用户*/
    int addUser(User user);
    /**增加用户改进*/
    int addUser2(Map<String,Object> map);
    /**删除用户*/
    int deleteUser(int id);
    /**修改用户*/
    int updateUser(User user);
    /**模糊查询*/
    List<User> getUserLike(String name);
}
