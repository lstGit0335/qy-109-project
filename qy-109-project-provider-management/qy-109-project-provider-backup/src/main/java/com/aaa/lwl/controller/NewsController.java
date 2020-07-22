package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.News;
import com.aaa.lwl.service.NewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:NewController
 * Author:李守堂
 * createTime:2020/7/17   22:22
 * version:1.0.0
 * Description
 */
@RestController
public class NewsController extends CommonController {



    @Autowired
    private NewsService newService;



    @Override
    public BaseService getBaseService() {
        return newService;
    }

    /**
     * 查询所有
     * @param news
     * @return
     */
    @PostMapping("/allNews")
    public ResultData selectAll(News news){
        List<News> news1 = newService.selectList(news);
        if (news1.size() > 0){
            return operationSuccess(news1);
        }else {
            return operationFailed();
        }
    }

    /**
     * 分页查询所有
     * @param news
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("/selectNewsByPage")
    public ResultData selectNewsByPage(News news, @RequestParam("pageNumber") Integer pageNumber,
                                       @RequestParam("pageSize") Integer pageSize){
        PageInfo<News> newsPageInfo = newService.selectListByPage(news, pageNumber, pageSize);
        if (newsPageInfo != null && !"".equals(newsPageInfo)){
            return operationSuccess(newsPageInfo);
        }else {
            return operationFailed();
        }
    }

    /**
     * 根据主键删除
     * @param news
     * @return
     */
    @PostMapping("/deleteNewsByid")
    public ResultData delete(News news){

        Integer delete = newService.delete(news);
        if (delete > 0){
            return DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }
    }

    /**
     * 增加数据
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    public ResultData insert(News news){
        Integer add = newService.add(news);
        if (add > 0){
            return INSERT_SUCCESS();
        }else {
            return INSERT_FAILED();
        }
    }

    /**
     * 更新数据
     * @param news
     * @return
     */
    @PostMapping("/updateNews")
    public ResultData update(News news){
        Integer update = newService.update(news);
        if (update > 0){
            return UPDATE_SUCCESS();

        }else {
            return UPDATE_FAILED();
        }
    }
}
