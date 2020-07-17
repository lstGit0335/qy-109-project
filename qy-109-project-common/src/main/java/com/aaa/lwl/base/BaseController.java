package com.aaa.lwl.base;

import static com.aaa.lwl.status.LoginStatus.*;
import static com.aaa.lwl.status.OperationStatus.*;
import static com.aaa.lwl.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.lwl.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @author wyh
 * date 2020-07-08
 * 统一controller
 * 所有的controller都要继承这个controller，进行统一返回
 *
 *             code:200 msg:登录成功
 *  *          code:400 msg:登录失败，系统异常
 *  *          code:201 msg:用户已经存在
 *  *          code:401 msg:用户不存在
 *  *          code:402 msg:密码错误
 *  *          code:405 msg:用户退出异常
 */
public class BaseController {
    /**
     * 登陆成功，使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 登陆成功，使用自定义消息
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 登录成功
     * 返回数据信息。使用系统消息
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return  resultData;
    }
    /**
     * 登录成功
     * 返回数据信息。使用自定义消息
     */
    protected ResultData loginSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * 登录失败，使用系统消息
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }
    /**
     * 登陆失败，使用系统消息，详细解释说明
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /**
     * 登录失败
     * 返回数据信息，使用系统消息
     */
    protected ResultData loginFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 登录失败
     * 返回数据信息，使用自定义消息
     */
    protected ResultData loginFailed(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录失败
     * 用户存在,使用系统消息，返回数据信息
     */
    protected ResultData UserExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }
    /**
     * 用户存在，使用自定义消息
     */
    protected ResultData UserExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 用户存在，使用系统消息、返回数据
     */
    protected ResultData UserExist(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 用户存在，使用自定义消息，返回数据
     */
    protected ResultData UserExist(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     *操作成功,返回系统消息
     */
    protected ResultData operationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     *操作成功,返回系统消息,自定义
     */
    protected ResultData operationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 操作失败，返回系统消息
     */
    protected ResultData operationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * 操作失败，使用自定义消息
     * @param data
     * @return
     */
    protected ResultData operationFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 删除成功，返回系统消息
     * @return
     */
    protected ResultData DELETE_SUCCESS(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 删除失败
     */
    protected ResultData DELETE_FAILED(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }
    /**
     * 修改成功，返回系统消息
     */
    protected ResultData UPDATE_SUCCESS(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 修改失败
     */
    protected ResultData UPDATE_FAILED(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
     *增加成功
     * @return
     */
    public ResultData INSERT_SUCCESS(){
        ResultData resultData=new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 增加失败
     */
    public ResultData INSERT_FAILED(){
        ResultData resultData=new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * 路由过滤成功
     * @return
     */
    public ResultData ZUUL_FILTER_SUCCESS(){
        ResultData resultData=new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 路由过滤失败
     * @return
     */
    public ResultData ZUUL_FILTER_FAILED(){
        ResultData resultData=new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     * token值存在
     * @return
     */
    public ResultData ZUUL_FILTER_TOKEN_SUCCESS(){
        ResultData resultData=new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    } /**
     * token值不存在
     * @return
     */
    public ResultData ZUUL_FILTER_TOKEN_FAILED(){
        ResultData resultData=new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     * reques对象为null
     * @return
     */
    public ResultData REQUEST_IS_NULL(){
        ResultData resultData=new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }
    /**
     * 用户不存在
     */
    public ResultData USER_NOT_EXIST(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }
    /**
     * 密码错误
     */
    public ResultData PASSWORD_WRONG(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }
    /**
     * 系统异常
     */
    public ResultData SYSTEM_EXCEPTION(){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_EXCEPTION.getCode());
        resultData.setMsg(SYSTEM_EXCEPTION.getMsg());
        return resultData;
    }
    /**
     * 查询成功
     * @param userAll
     */
    public ResultData selectSuccess(Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_SUCCESS.getCode());
        resultData.setMsg(SELECT_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 查询失败
     * @param userAll
     */
    public ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_FAILED.getCode());
        resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        return resultData;
    }

}
