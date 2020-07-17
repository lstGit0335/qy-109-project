package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseController;
import com.aaa.lwl.model.Menu;
import com.aaa.lwl.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:MenuController
 * Author:李守堂
 * createTime:2020/7/16   8:52
 * version:1.0.0
 * Description
 */
@RestController
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    /**
     * 查询所有菜单
     * @param menu
     * @return
     */
    @PostMapping("/all")
    public List<Menu> selectList(Menu menu){
        return menuService.selectList(menu);

    }

    /**
     * 增加菜单
     * @param menu
     * @return
     */

    @PostMapping("/insertMenu")
    public Integer insert(Menu menu){
        return menuService.insert(menu);
    }

    /**
     *更新菜单
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    public Integer update(Menu menu){
        return menuService.update(menu);
    }

    /**
     * 删除菜单
     * @param menu
     * @return
     */
    @PostMapping("/deleteMenu")
    public Integer delete(Menu menu){
        return menuService.delete(menu);
    }

}
