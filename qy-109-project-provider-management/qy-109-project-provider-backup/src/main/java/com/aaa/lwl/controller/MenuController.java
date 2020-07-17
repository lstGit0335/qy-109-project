package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.model.Menu;
import com.aaa.lwl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:MenuController
 * Author:李守堂
 * createTime:2020/7/16   8:34
 * version:1.0.0
 * Description
 */
@RestController
public class MenuController extends CommonController<Menu> {

    @Autowired
    private MenuService menuService;

    @Override
    public BaseService<Menu> getBaseService() {
        return menuService;
    }

    /**
     * 查询所有菜单
     * @param menu
     * @return
     */
    @GetMapping("/allMenu")
    public List<Menu> selectList( Menu menu){
        return menuService.selectList(menu);
    }

    /**
     * 根据主键删除菜单
     * @param menu
     * @return
     */
    @GetMapping("/deleteMenu")
    public Integer delete(Menu menu){
        return menuService.delete(menu);
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @GetMapping("/insertMenu")
    public Integer add(Menu menu){
        return menuService.add(menu);
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @GetMapping("/updateMenu")
    public Integer update(Menu menu){
        return menuService.update(menu);
    }

}
