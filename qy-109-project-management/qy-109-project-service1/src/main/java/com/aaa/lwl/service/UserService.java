package com.aaa.lwl.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.mapper.UserMapper;
import com.aaa.lwl.model.User;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lwl.status.AddStatus.*;
import static com.aaa.lwl.status.DeleteStatus.*;
import static com.aaa.lwl.status.SelectStatus.*;
import static com.aaa.lwl.status.UpdateStatus.*;

/**
 * @author wyh
 * date 2020-07-17
 */
@Service
@Slf4j
public class UserService  extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
    /**
     * 查询用户全部信息
     */
    public Map<String ,Object> selectAllUser(){
        Map<String,Object> resultMap = new HashMap<String, Object>();

        List<User> allUserResult = userMapper.selectAll();
        if (allUserResult != null){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",allUserResult);

        } else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 修改员工信息
     */
    public ResultData updateUser(User user){
        ResultData resultData = new ResultData();
        int i  = userMapper.updateByPrimaryKeySelective(user);
        return i > 0 ? resultData.setCode(UPDATE_DATA_SUCCESS.getCode()).setMsg(UPDATE_DATA_SUCCESS.getMsg())
                : resultData.setCode(UPDATE_DATA_FAILED.getCode()).setMsg(UPDATE_DATA_FAILED.getMsg());
    }
    /**
     * 批量删除用户
     */
    public Map<String,Object> delUser(List<Long> ids){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Example example = Example.builder(User.class).where(Sqls.custom().andIn("id",ids)).build();
        int i = userMapper.deleteByExample(example);
        if (i > 0){
            resultMap.put("code", DELETE_DATA_SUCCESS.getCode());
            resultMap.put("msg", DELETE_DATA_SUCCESS.getMsg());
        }else{
            resultMap.put("code", DELETE_DATA_FAILED.getCode());
            resultMap.put("msg", DELETE_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 删除通过id
     */
    public Map<String,Object> delUserByid(@RequestParam("userId") Long userId){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i > 0){
            resultMap.put("code", DELETE_DATA_SUCCESS.getCode());
            resultMap.put("msg", DELETE_DATA_SUCCESS.getMsg());
        } else {
            resultMap.put("code", DELETE_DATA_FAILED.getCode());
            resultMap.put("msg", DELETE_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 增加用户
     */
    public Map<String,Object> addUser(User user){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        user.setCreateTime(DateUtil.now());
        int addResult = userMapper.insert(user);

        if (addResult > 0){
            resultMap.put("code", ADD_DATA_SUCCESS.getCode());
            resultMap.put("msg", ADD_DATA_SUCCESS.getMsg());
        }else{
            resultMap.put("code", ADD_DATA_FAILED.getCode());
            resultMap.put("msg", ADD_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * 分页查询全部用户
     */
//    public Map<String,Object> selectUserAllByPage(HashMap map){
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//            if (map.size()>0){
//                PageInfo<HashMap> pageInfo = super.selectListByPage(map);
//                if (null != pageInfo && pageInfo.getSize() > 0 ){
//                    resultMap.put("code", SELECT_DATA_SUCCESS.getCode());
//                    resultMap.put("msg", pageInfo);
//                    return resultMap;
//            }else {
//                    resultMap.put("code", SELECT_DATA_FAILED.getCode());
//                    resultMap.put("msg", SELECT_DATA_FAILED.getMsg());
//                }
//            }
//            return resultMap;
//        }

}
