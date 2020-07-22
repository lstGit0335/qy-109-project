package com.aaa.lwl.controller;

import com.aaa.lwl.api.IProjectService;
import com.aaa.lwl.base.BaseController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Dept;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:DeptController
 * Author:李守堂
 * createTime:2020/7/16   10:52
 * version:1.0.0
 * Description
 */
@RestController
public class DeptController extends BaseController {
    @Autowired
    private IProjectService deptService;

    @PostMapping("/allDept")
    public ResultData selectList(Dept dept) {
        return deptService.selectList(dept);

    }

    @PostMapping("/deleteDept")
    Integer delete( Dept dept) {
        return deptService.delete(dept);
    }

    @PostMapping("/updateDept")
    Integer update( Dept dept) {
        return deptService.update(dept);
    }

    @PostMapping("/insertDept")
    Integer insert( Dept dept) {

        return deptService.insert(dept);
    }
}
