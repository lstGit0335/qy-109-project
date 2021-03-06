package com.aaa.lwl.status;


/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:14
 * @Description
 **/
public enum LoginStatus {

    LOGIN_SUCCESS("200","登陆成功"),
    LOGIN_FAILED("400", "登录失败，系统异常"),
    USER_EXIST("201", "用户已经存在"),
    USER_NOT_EXIST("401", "用户不存在"),
    PASSWORD_WRONG("402", "密码错误"),
    LOGIN_WRONG("405","用户退出异常"),
    SYSTEM_EXCEPTION("406","系统异常");


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    LoginStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
