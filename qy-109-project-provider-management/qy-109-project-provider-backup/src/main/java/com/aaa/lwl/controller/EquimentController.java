package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Equiment;
import com.aaa.lwl.service.EquimentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:EquimentController
 * Author:李守堂
 * createTime:2020/7/17   22:22
 * version:1.0.0
 * Description
 */
@RestController
public class EquimentController extends CommonController {



    @Autowired
    private EquimentService equimentService;

    @Override
    public BaseService getBaseService() {
        return null;
    }

    /**
     * 分页查询所有
     * @param equiment
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("/selcetEquimentByPage")
    public ResultData selcetEquimentByPage(Equiment equiment,
                                           @RequestParam("pageNumber") Integer pageNumber,
                                           @RequestParam("pageSize") Integer pageSize){
        PageInfo<Equiment> equimentPageInfo = equimentService.selectListByPage(equiment, pageNumber, pageSize);
        if(equimentPageInfo != null && !"".equals(equimentPageInfo)){
            return operationSuccess(equimentPageInfo);
        }else{
            return operationFailed();
        }

    }

    /**
     * 查询所有
     * @param equiment
     * @return
     */
    @PostMapping("/allEquiment")
    public ResultData selectAll(Equiment equiment){
        List<Equiment> equiments = equimentService.selectList(equiment);
        if (equiments.size()>0){
            return operationSuccess(equiments);
        }else {
            return operationFailed();
        }
    }

    /***
     * 删除通过主键
     * @param equiment
     * @return
     */
    @PostMapping("/deleteEquimentById")

    public ResultData deleteByID(Equiment equiment){
        Integer delete = equimentService.delete(equiment);
        if (delete > 0){
            return DELETE_SUCCESS();
        }else {

            return DELETE_FAILED();
        }
    }

    /**
     * 通过主键批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteEquimentByIds")
    public ResultData deleteByIds(@RequestParam("ids") List<Integer> ids){
        Integer integer = equimentService.deleteByIds(ids);
        if (integer >0){
            return DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }
    }

    /**
     * 更新数据
     * @param equiment
     * @return
     */
    @PostMapping("/updateEquiment")
    public ResultData update(Equiment equiment){
        Integer update = equimentService.update(equiment);
        if (update > 0){
            return UPDATE_SUCCESS();
        }else {
            return UPDATE_FAILED();
        }
    }

    /**
     * 增加数据
     * @param equiment
     * @return
     */
    @PostMapping("/insertEquiment")
    public ResultData insert(Equiment equiment){
        Integer add = equimentService.add(equiment);
        if (add > 0){
            return INSERT_SUCCESS();
        }else {
            return INSERT_FAILED();
        }
    }


}
