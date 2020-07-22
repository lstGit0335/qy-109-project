package com.aaa.lwl.mapper;

import com.aaa.lwl.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> selectUserAll(String username,Integer deptId);

//    List<User> selectByFiled( String username);
}