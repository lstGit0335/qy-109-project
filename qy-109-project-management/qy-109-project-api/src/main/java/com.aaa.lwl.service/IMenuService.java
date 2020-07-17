package com.aaa.lwl.service;

import com.aaa.lwl.model.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * fileName:MenuService
 * Author:李守堂
 * createTime:2020/7/16   8:53
 * version:1.0.0
 * Description
 */
@FeignClient(value = "")
public interface IMenuService {


    /**
     * 查询所有
     * @param menu
     * @return
     */
    @PostMapping("/all")
    List<Menu>  selectList(@RequestBody Menu menu);

    @PostMapping("/deleteMenu")
    Integer delete(@RequestBody Menu menu);

    @PostMapping("/updateMenu")
    Integer update(@RequestBody Menu menu);

    @PostMapping("/insertMenu")
    Integer insert(@RequestBody Menu menu);
}
