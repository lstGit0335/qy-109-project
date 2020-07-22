package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Menu;
import com.aaa.lwl.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
     * 查询所有菜单分页查询
     * @param menu
     * @return
     */
    @PostMapping("/allMenu")
    public ResultData selectList(Menu menu, @RequestParam("pageNumber") Integer pageNumber,
                                 @RequestParam("pageSzie") Integer pageSize){
        PageInfo<Menu> menuPageInfo = menuService.selectListByPage(menu, pageNumber, pageSize);
        if (menuPageInfo != null && !"".equals(menuPageInfo)){
            return operationSuccess(menuPageInfo);
        }else {
            return operationFailed();
        }
    }

    /**
     * 根据主键删除菜单
     * @param menu
     * @return
     */
    @GetMapping("/deleteMenu")
    public ResultData delete(Menu menu){
        Integer delete = menuService.delete(menu);
        if (delete > 0){
            return  DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @GetMapping("/insertMenu")
    public ResultData add(Menu menu){
        Integer add = menuService.add(menu);
        if (add > 0){
            return INSERT_SUCCESS();
        }else {
            return INSERT_FAILED();
        }
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @GetMapping("/updateMenu")
    public ResultData update(Menu menu){
        Integer update = menuService.update(menu);
        if (update > 0){
            return UPDATE_SUCCESS();
        }else {
            return UPDATE_FAILED();
        }
    }

}
