package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private IDeptService deptService;

    @PostMapping("/allDept")
    public ResultData selectList(@RequestBody Dept dept) {
        return deptService.selectList(dept);
    }

    @PostMapping("/deleteDept")
    Integer delete(@RequestBody Dept dept) {
        return deptService.delete(dept);
    }

    @PostMapping("/updateDept")
    Integer update(@RequestBody Dept dept) {
        return deptService.update(dept);
    }

    @PostMapping("/insertDept")
    Integer insert(@RequestBody Dept dept) {

        return deptService.insert(dept);
    }
}
