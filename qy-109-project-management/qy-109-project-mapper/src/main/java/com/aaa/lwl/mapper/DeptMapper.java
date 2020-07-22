package com.aaa.lwl.mapper;

import com.aaa.lwl.model.Dept;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {

    List<Dept> selectByName(String deptName);



}