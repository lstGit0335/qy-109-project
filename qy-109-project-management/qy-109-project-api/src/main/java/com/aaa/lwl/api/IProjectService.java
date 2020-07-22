package com.aaa.lwl.api;

import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * fileName:IProjectService
 * Author:李守堂
 * createTime:2020/7/20   19:30
 * version:1.0.00.
 * Description
 */
@FeignClient(value = "emp-interface")
public interface IProjectService {

    /**
     * 执行登录操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    ResultData doLogin(User user);


    /**
     * 新增日志
     * @param loginLog
     * @return
     */

    @PostMapping("/addLoginLog")
    Integer addLoginLog( LoginLog loginLog);



    @PostMapping("/allDept")
    ResultData selectList( Dept dept);

    @PostMapping("/deleteDept")
    Integer delete( Dept dept);

    @PostMapping("/updateDept")
    Integer update( Dept dept);

    @PostMapping("/insertDept")
    Integer insert( Dept dept);


    @PostMapping("/allDict")
    List<Dict> selectList(Dict dict);

    /**
     * 根据主键删字典表
     * @param dict
     * @return
     */
    @PostMapping("/deleteDict")
    Integer delete(Dict dict);
    /**
     * 新增字典表
     * @param dict
     * @return
     */
    @PostMapping("/insertDict")
    Integer add(Dict dict);

    /**
     * 更新字典表
     * @param dict
     * @return
     */
    @PostMapping("/updateDict")
    Integer update(Dict dict);


    /**
     * 查询所有
     * @param menu
     * @return
     */
    @PostMapping("/all")
    List<Menu> selectList(Menu menu);

    @PostMapping("/deleteMenu")
    Integer delete( Menu menu);

    @PostMapping("/updateMenu")
    Integer update( Menu menu);

    @PostMapping("/insertMenu")
    Integer insert( Menu menu);




    @PostMapping("/allUser")
    ResultData selectAllUser ( User user);

}
