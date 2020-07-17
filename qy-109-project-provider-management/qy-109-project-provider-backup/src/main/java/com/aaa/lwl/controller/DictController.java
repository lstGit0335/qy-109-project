package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.model.Dict;
import com.aaa.lwl.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/allDict")
    public List<Dict> selectList(Dict dict){
        return dictService.selectList(dict);
    }

    /**
     * 根据主键删字典表
     * @param dict
     * @return
     */
    @GetMapping("/deleteDict")
    public Integer delete(Dict dict){
        return dictService.delete(dict);
    }

    /**
     * 新增字典表
     * @param dict
     * @return
     */
    @PostMapping("/insertDict")
    public Integer add(@RequestBody Dict dict){
        return dictService.add(dict);
    }

    /**
     * 更新字典表
     * @param dict
     * @return
     */
    @GetMapping("/updateDict")
    public Integer update(Dict dict){
        return dictService.update(dict);
    }

    /**
     * 根据主键批量删除
     * @param ids
     * @return
     */

    @GetMapping("/deleteDictByIds")
    public Integer deleteDictByIds(@RequestParam("dictIds") List<Integer> dictIds){
        return dictService.deleteByIds(dictIds);
    }
}
