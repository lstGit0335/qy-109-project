package com.aaa.lwl.base;

/**
 * fileName:BaseService
 * Author:李守堂
 * createTime:2020/7/8   20:04
 * version:1.0.0
 * Description
 */


import com.aaa.lwl.utils.Map2BeanUtils;
import com.aaa.lwl.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.lwl.staticproperties.OrderStatic.ASC;
import static com.aaa.lwl.staticproperties.OrderStatic.DESC;

public abstract class BaseService<T> {
    //全局变量，缓存子类的泛型
    private Class<T> cache = null;
    @Autowired
    private Mapper<T> mapper;

    protected  Mapper getMapper(){
        return mapper;
    }

    /**
     * 新增数据
     * @param t
     * @return
     */
    public Integer add(T t) {
        return mapper.insert(t);
    }


    /**
     * 根据主键删除
     * @param t
     * @return
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 根据主键批量删除
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Integer> ids){

        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByExample(example);

    }

    /**
     * 更新操作
     * @param t
     * @return
     */
    public Integer update(T t){
        return mapper.updateByPrimaryKeySelective(t);

    }

    /**
     * 批量修改
     * @param t
     * @param ids
     * @return
     */
    public Integer batchUpdate(T t,Integer[] ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);

    }


    /**
     * 查询一条数据
     * @param t
     * @return
     */
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }


    /**
     * 集合查询
     * @param t
     * @return
     */

    public List<T> selectList(T t){
        return mapper.select(t);
    }
    /**
     *查询一条数据，进行排序
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public T selectOneByFiled(Sqls where,String orderByFiled,String... fileds){
        return (T) selectByFileds(null,null,where,orderByFiled,null,fileds).get(0);
    }

    /**
     * 通过条件查询一个列表
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public List<T> selectListByFiled(Sqls where,String orderByFiled,String... fileds){
        return selectByFileds(null,null,where,orderByFiled,null,fileds);
    }

    /**
     * 实现条件查询的分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderByFiled
     * @param fileds
     * @return
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo,Integer pageSize,Sqls where,String orderByFiled,String... fileds){
        return new PageInfo<T>(selectByFileds(pageNo,pageSize,where,orderByFiled,null,fileds));
    }

    /**
     * 集合查询，分页查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<T> selectListByPage(T t ,Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * map转化实体类型
     * @param map
     * @return
     */
    public T newInstance(Map map){
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }

    /**
     * 实现查询通用
     *      具有分页，排序，多条件查询
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderByFiled
     * @param orderWord
     * @param fileds
     * @return
     */

    private List<T> selectByFileds(Integer pageNo,Integer pageSize,Sqls where ,String orderByFiled,String orderWord,String... fileds){
        Example.Builder builder = null;
        if (null == fileds || fileds.length == 0){
            //查询所有
            builder = Example.builder(getTypeArguement());
        }else {
            //说明按需要进行条件查询

            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if (where != null){
            //说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if (orderByFiled != null){

            if (DESC.equals(orderWord.toUpperCase())){
                //说名要进行倒序
                builder = builder.orderByDesc(orderByFiled);
            }else if (ASC.equals(orderByFiled.toUpperCase())){
                builder = builder.orderByAsc(orderByFiled);
            }else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }

        Example example = builder.build();

        //实现分页
        if (pageNo != null & pageSize != null){
            PageHelper.startPage(pageNo,pageSize);
        }
        return getMapper().selectByExample(example);
    }


    /**
     * 获取子类泛型类型
     * @return
     */
    public Class<T> getTypeArguement(){
        if (null == cache){
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }

        return cache;
    }


    public ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }
}
