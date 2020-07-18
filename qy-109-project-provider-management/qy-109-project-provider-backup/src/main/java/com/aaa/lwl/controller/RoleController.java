package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseController;

import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.service.RoleService;
import com.aaa.lwl.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wyh
 * date 2020-07-18
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;
    /**
     * 查询所有的角色
     */
    @GetMapping("/allRoles")
    public ResultData selectAllRole(){
        ResultData resultData = roleService.selectAllRole();
        if ("20010" == resultData.getCode()){
            return selectSuccess(resultData.getData());
        }else {
            return selectFailed();
        }
    }
    /**
     * 简单的分页查询
     */
    @PostMapping("/pageRoles")
    public ResultData selectAllRoleByPage(RoleVo roleVo){
        ResultData resultData = roleService.selectAllRoleByPage(roleVo);
        if ("20010" == resultData.getCode()){
            return selectSuccess(resultData.getData());
        }else {
            return selectFailed();
        }
    }
    /**
     * 角色删除
     */
    @PostMapping("/deleteRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId){
        Boolean bool = roleService.deleteRole(roleId);
        if (bool == true){
            return deleteSuccess();
        } else {
            return deleteFailed();
        }
    }

    /**
     * 修改角色及权限
     * @param roleVo
     * @return
     */
    @PostMapping("/insertRole")
    public ResultData insertRole(@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.insertRole(roleVo);
        if (true == aBoolean){
            return super.INSERT_SUCCESS();
        }else {
            return super.INSERT_FAILED();
        }
    }

}
