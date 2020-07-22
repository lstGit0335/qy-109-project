package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Dept;
import com.aaa.lwl.service.DeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:DeptController
 * Author:李守堂
 * createTime:2020/7/16   10:38
 * version:1.0.0
 * Description
 */
@RestController
public class DeptController extends CommonController<Dept> {


    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }

    /**
     * 查询所有部门分页查询
     * @param dept
     * @return
     */
    @PostMapping("/allDept")
    public ResultData selectList(Dept dept, @RequestParam("pageNumber") Integer pagenumber, @RequestParam("pageSize") Integer pageSize){
        PageInfo<Dept> deptPageInfo = deptService.selectListByPage(dept, pagenumber, pageSize);
        if (deptPageInfo != null && !"".equals(deptPageInfo)){
            return operationSuccess(deptPageInfo);
        }else {
            return operationFailed();
        }
    }




    /**
     *删除部门
     * @param dept
     * @return
     */
    @PostMapping("/deleteDept")
    public ResultData delete(Dept dept) {
        Integer delete = deptService.delete(dept);
        if (delete > 0 ){
            return operationSuccess(delete);
        }else {
            return operationFailed();
        }
    }

    /**-
     * 查詢
     * @param deptName
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("/selectListByFiled")
    public ResultData selectListByFiled(@RequestParam("deptName") String deptName,
                                        @RequestParam("pageNumber") Integer pageNumber,
                                        @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = deptService.selectDeptByDeptName(deptName,pageNumber,pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo).setData(pageInfo);
        }else {
            return selectFailed();
        }


    }
    /**
     *
     * 根据主键更新部门
     * @param dept
     * @return
     */
    @PostMapping("/updateDept")
    public ResultData update(Dept dept) {
        Integer update = deptService.update(dept);
        if (update > 0){
            return operationSuccess(update);
        }else {
            return operationFailed();
        }

    }

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    @PostMapping("/insertDept")
   public ResultData insert(Dept dept) {
        Integer addDept = deptService.add(dept);
        if (addDept > 0){
            return operationSuccess(addDept);
        }else {
            return operationFailed();
        }
    }

    /**
     * 根據主鍵批量刪除
     * @param ids
     * @return
     */

    @PostMapping("/deleteDeptByIds")
   public ResultData deleteByIds(List<Integer> ids){

        Integer integer = deptService.deleteByIds(ids);
        if (integer > 0) {

            return operationSuccess(integer);
        }else {

            return operationFailed();
        }
    }


    /**
     * 查询一个
     *
     * @param deptId
     * @return
     */
    @PostMapping("/selectDeptById")

    public ResultData selectOne(@RequestParam("deptId") Dept deptId){
        Dept dept = deptService.selectOne(deptId);
        if (dept != null && !"".equals(dept)){
            return operationSuccess(dept);
        }else {
            return operationFailed();
        }

    }

}
