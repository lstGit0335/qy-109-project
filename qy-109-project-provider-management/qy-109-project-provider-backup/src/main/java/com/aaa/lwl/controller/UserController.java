package com.aaa.lwl.controller;

import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.User;
import com.aaa.lwl.service.UserService;
import com.aaa.lwl.status.OperationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * fileName:UserController
 * Author:李守堂
 * createTime:2020/7/17   18:37
 * version:1.0.0
 * Description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 按照，名称查询
     * @param username
     * @return
     */
//    @PostMapping("/selectUserByFiled")
//    public List<User> selectByFiled(@RequestParam("username") String username) {
//
//        return userService.selectByFiled(username);
//
//    }

    @PostMapping("/selectAllUser")
    public ResultData selectAllUser(@RequestParam("username") String username, @RequestParam("deptId")Integer deptId){
       return userService.selectAllUser(username, deptId);


    }
}
