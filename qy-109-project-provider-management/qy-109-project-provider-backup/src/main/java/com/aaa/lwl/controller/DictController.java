package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Dict;
import com.aaa.lwl.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * fileName:DictController
 * Author:李守堂
 * createTime:2020/7/16   10:25
 * version:1.0.0
 * Description
 */
@RestController
public class DictController  extends CommonController<Dict> {


    @Autowired
    private DictService dictService;

    @Override
    public BaseService<Dict> getBaseService() {
        return dictService;
    }


    /**
     * 查询所有字典
     * @param dict
     * @return
     */
    @PostMapping("/allDict")
    public ResultData selectList(Dict dict , @RequestParam("pageNumber") Integer pageNumber,
                                 @RequestParam("pageSize") Integer pageSzie){
        PageInfo<Dict> dictPageInfo = dictService.selectListByPage(dict, pageNumber, pageSzie);
        if (dictPageInfo != null && !"".equals(dictPageInfo)){
            return operationSuccess(dictPageInfo).setData(dictPageInfo);
        }else {
            return operationFailed();
        }
    }

    /**
     * 根据主键删字典表
     * @param dict
     * @return
     */
    @PostMapping("/deleteDict")
    public ResultData delete(Dict dict){
        Integer delete = dictService.delete(dict);
        if (delete > 0){
            return DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }
    }

    /**
     * 新增字典表
     * @param dict
     * @return
     */
    @PostMapping("/insertDict")
    public ResultData add(Dict dict){
        Integer add = dictService.add(dict);
        if (add > 0){
            return INSERT_SUCCESS();
        }else {
            return INSERT_FAILED();
        }
    }

    /**
     * 更新字典表
     * @param dict
     * @return
     */
    @PostMapping("/updateDict")
    public ResultData update(Dict dict){
        Integer update = dictService.update(dict);
        if (update > 0){
            return UPDATE_SUCCESS();
        }else {
            return UPDATE_FAILED();
        }
    }

    /**
     * 根据主键批量删除
     * @param ids
     * @return
     */

    @PostMapping("/deleteDictByIds")
    public ResultData deleteDictByIds(@RequestParam("dictIds") List<Integer> dictIds){
        Integer integer = dictService.deleteByIds(dictIds);
        if (integer > 0){
            return DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }

    }
}
