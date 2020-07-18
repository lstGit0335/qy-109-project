package com.aaa.lwl.service;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.mapper.MappingProjectMapper;
import com.aaa.lwl.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lwl.status.SelectStatus.*;

/**
 * @author wyh
 * date 2020-07-17
 */

@Service
public class MappingProjectService extends  BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    /**
     * 项目查询,项目名称的模糊查询，类型，日期精确查询
     */
    public Map<String,Object> projectSelect(MappingProject mappingProject){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<HashMap> restdata = new ArrayList<>();
        if (null == mappingProject){
            restdata = mappingProjectMapper.SelectAllProject();
        }
        else {
            restdata = mappingProjectMapper.projectSelect(mappingProject);
        }
        if (restdata.size()>0){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 通过字段查询所有的类型和开工日期
     */
    public Map<String,Object> SelectGroupName(String name){

        HashMap<String, Object> resultMap = new HashMap<>();
        List<HashMap> restdata = new ArrayList<>();

        restdata= mappingProjectMapper.SelectGroupName(name);
        if (restdata.size()>0){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 通过id查询测绘工程详细信息
     */
    public HashMap<String,Object> projectDetail(String id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (null != id && !("").equals(id)) {
            List<HashMap> restdata = mappingProjectMapper.projectDetail(id);
            if ( restdata.size() ==1) {
                resultMap.put("code", SELECT_DATA_BY_ID_SUCCESS.getCode());
                resultMap.put("msg", SELECT_DATA_BY_ID_SUCCESS.getMsg());
                resultMap.put("data", restdata);
                return resultMap;
            }
        }
        resultMap.put("code", SELECT_DATA_BY_ID_FAILED.getCode());
        resultMap.put("msg", SELECT_DATA_BY_ID_FAILED.getMsg());
        return resultMap;
    }
    /**
     * 项目查询
     */
    public List<MappingProject> selectAllPros(Long userId){
        try {
            //查询公司信息
            List<MappingProject> manProjects = mappingProjectMapper.selectAllPros(userId);
            //判断是否查询出值
            if (!"".equals(manProjects) && null != manProjects){
                return manProjects;
            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 根据主键id查询
     */
    public MappingProject selectById(Long id){
        try {
            if (!"".equals(id)){
                //根据id获取项目信息
                MappingProject manProject = mappingProjectMapper.selectByPrimaryKey(id);
                //判断是否存在该项目
                if (!"".equals(manProject) && null != manProject){
                    return manProject;
                }else {
                    return null;
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 通过id修改项目
     */
    public Integer updateById(MappingProject manProject){
        System.out.println(manProject);
        int i = 0;
        try {
            if (!"".equals(manProject)){
                //执行修改的方法 返回受影响的行数
                i = mappingProjectMapper.updateByPrimaryKeySelective(manProject);
                //判断受影响的行数
                if (i>0){
                    return i;
                }else {
                    //再次执行修改操作
                    int j = mappingProjectMapper.updateByPrimaryKeySelective(manProject);
                    if (j>0){
                        return j;
                    }
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
