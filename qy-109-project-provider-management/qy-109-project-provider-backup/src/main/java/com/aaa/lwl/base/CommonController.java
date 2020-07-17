package com.aaa.lwl.base;

import com.aaa.lwl.base.BaseController;
import com.aaa.lwl.base.ResultData;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * fileName:CommonController
 * @Author:李守堂
 * createTime:2020/7/8   21:18
 * version:1.0.0
 * Description
 */
public abstract class CommonController<T> extends BaseController {




    protected void beforeAdd(Map map){
        //TODO AddMethod Bofore to do something
    }

    protected void afterAdd(Map map){
        //TODO AddMethod After to do something
    }



    public abstract BaseService<T> getBaseService();

    /**
     * 通用新增方法
     * @param map
     * @return
     */
    public ResultData add(@RequestBody Map map) {

        beforeAdd(map);
        //map转为实体类
        T instace = getBaseService().newInstance(map);
        //通用service
        Integer addResult = getBaseService().add(instace);
        if (addResult > 0 ){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * 删除操作
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer deleteResultData = getBaseService().delete(instance);
        if (deleteResultData > 0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ResultData batchDelete(@RequestParam("ids[]") Integer ids){
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     *
     * 更新操作
     * @param map
     * @return
     */
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer updateResultData = getBaseService().update(instance);
        if (updateResultData > 0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * 批量修改
     * @param map
     * @param ids
     * @return
     */
    public ResultData batchUpdate(@RequestBody Map map,@RequestParam("ids[]") Integer[] ids){
        T instance = getBaseService().newInstance(map);
        Integer updateResult = getBaseService().batchUpdate(instance,ids);
        if (updateResult > 0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * 查询一条信息
     * @param map
     * @return
     */
    public ResultData selectOne(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);

        T  selectOne=getBaseService().selectOne(instance);

        if (selectOne != null ){
            return super.operationSuccess();
        }
        return super.operationFailed();

    }


    /**
     * 带条件的多条查询
     * @param map
     * @return
     */

    public ResultData getList(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
       List<T> selectList =getBaseService().selectList(t);
        if (selectList.size()> 0){
            return super.operationSuccess(selectList);
        }
        return super.operationFailed("未找到查询结果");
    }

    /**
     * 带条件的分页查询
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */

    public ResultData selectListByPage(@RequestBody Map map,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        T t = getBaseService().newInstance(map);
        PageInfo<T> pageInfo = getBaseService().selectListByPage(t,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if (resultList.size()>0){
            return  operationSuccess(pageInfo);
        }

        return operationFailed("未找到查询结果");
    }


    /**
     * 不带条件的分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */

    public ResultData selectListByPage(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
        PageInfo<T> pageInfo = getBaseService().selectListByPage(null, pageNo, pageSize);
        List<T> resultList = pageInfo.getList();
        if (resultList.size()> 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }
    /**
     * 从本地当前线程中获取request对象
     * @return
     */
    public HttpServletRequest getServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes){
            servletRequestAttributes =(ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }


    /**
     * 获取当前客户端的session对象（如果没有那就创建一个新的session）
     * @return
     */
    public HttpSession getSession(){
        return getServletRequest().getSession();
    }

    /**
     * 获取当前客户端的session对象（如果没有就直接返回null）
     * @return
     */

    public HttpSession getExistSession(){

        return getServletRequest().getSession(false);
    }

}
