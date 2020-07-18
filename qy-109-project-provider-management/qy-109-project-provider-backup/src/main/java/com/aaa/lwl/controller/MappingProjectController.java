package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.MappingProject;
import com.aaa.lwl.model.MappingUnit;
import com.aaa.lwl.redis.RedisService;
import com.aaa.lwl.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.lwl.status.SelectStatus.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyh
 * date 2020-07-17
 */
@RestController
public class MappingProjectController extends CommonController<MappingUnit> {
    @Autowired
    private MappingProjectService mappingProjectService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/projectSelect")
    public ResultData projectSelect( MappingProject mappingProject){
        Map<String, Object> resultMap = mappingProjectService.projectSelect(mappingProject);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }
    @PostMapping("/SelectGroupName")
    public ResultData SelectGroupName(@RequestParam ("name") String name){
        System.out.println(name);
        Map<String, Object> resultMap = mappingProjectService.SelectGroupName(name);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }
    @PostMapping("/projectDetail")
    public ResultData projectDetail(@RequestParam("id") String id){
        Map<String, Object> resultMap = mappingProjectService.projectDetail(id);
        if (SELECT_DATA_BY_ID_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }


    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }
}
