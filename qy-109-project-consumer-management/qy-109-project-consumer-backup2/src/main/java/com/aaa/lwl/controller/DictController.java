package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseController;
import com.aaa.lwl.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:DictController
 * Author:李守堂
 * createTime:2020/7/16   10:32
 * version:1.0.0
 * Description
 */
@RestController
public class DictController extends BaseController {
    @Autowired
    IDictService dictService;

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
    @GetMapping("/insertDict")
    public Integer add(Dict dict){
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
}
