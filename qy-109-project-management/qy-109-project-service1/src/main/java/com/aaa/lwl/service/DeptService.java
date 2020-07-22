package com.aaa.lwl.service;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.mapper.DeptMapper;
import com.aaa.lwl.model.Dept;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * fileName:DeptService
 * Author:李守堂
 * createTime:2020/7/16   10:37
 * version:1.0.0
 * Description
 */
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    public PageInfo selectDeptByDeptName(@RequestParam("deptName") String deptName, Integer pageNumber, Integer pageSize) {

        PageHelper.startPage(pageNumber,pageSize);

        try {
            List<Dept> depts = deptMapper.selectByName(deptName);

            if (depts != null && !"".equals(depts)) {

                PageInfo<Dept> deptPageInfo = new PageInfo<Dept>(depts);

                if (deptPageInfo != null && !"".equals(deptPageInfo)) {
                    return deptPageInfo;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
