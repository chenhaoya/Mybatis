package com.ch.dao;

import com.ch.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**获取全部查询用户*/
    List<User> getUserList();
    /**根据ID查询用户*/
    User getUserById(int id);
    /**增加用户*/
    int addUser(User user);
    /**删除用户*/
    int deleteUser(int id);
    /**修改用户*/
    int updateUser(User user);
}
