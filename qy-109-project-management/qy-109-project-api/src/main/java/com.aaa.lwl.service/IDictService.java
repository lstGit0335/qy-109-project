package com.aaa.lwl.service;

import com.aaa.lwl.model.Dict;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * fileName:IDictService
 * Author:李守堂
 * createTime:2020/7/16   10:30
 * version:1.0.0
 * Description
 */
@Service
public interface IDictService  {



    @GetMapping("/allDict")
     List<Dict> selectList(Dict dict);

    /**
     * 根据主键删字典表
     * @param dict
     * @return
     */
    @GetMapping("/deleteDict")
     Integer delete(Dict dict);
    /**
     * 新增字典表
     * @param dict
     * @return
     */
    @GetMapping("/insertDict")
     Integer add(Dict dict);

    /**
     * 更新字典表
     * @param dict
     * @return
     */
    @GetMapping("/updateDict")
     Integer update(Dict dict);
}
