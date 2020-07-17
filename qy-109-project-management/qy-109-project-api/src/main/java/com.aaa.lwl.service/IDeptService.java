package com.aaa.lwl.service;

import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Dept;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * fileName:DeptService
 * Author:李守堂
 * createTime:2020/7/16   10:40
 * version:1.0.0
 * Description
 */
@Service
public interface IDeptService {

    @PostMapping("/allDept")
    ResultData selectList(@RequestBody Dept dept);

    @PostMapping("/deleteDept")
    Integer delete(@RequestBody Dept dept);

    @PostMapping("/updateDept")
    Integer update(@RequestBody Dept dept);

    @PostMapping("/insertDept")
    Integer insert(@RequestBody Dept dept);
}
