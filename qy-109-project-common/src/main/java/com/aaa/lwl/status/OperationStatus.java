package com.aaa.lwl.status;

/**
 *
 */
public enum OperationStatus {
    SUCCESS("1", "操作成功"),
    FAILED("2", "操作失败"),
    DELETE_SUCCESS("3", "删除成功"),
    DELETE_FAILED("12","删除失败"),
    UPDATE_SUCCESS("4", "修改成功"),
    UPDATE_FAILED("4", "修改失败"),
    INSERT_SUCCESS("5", "新增成功"),
    INSERT_FAILED("11","新增失败"),
    ZUUL_FILTER_SUCCESS("6", "路由过滤成功"),
    ZUUL_FILTER_FAILED("7", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("8", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("9", "token值不存在"),
    REQUEST_IS_NULL("10", "request对象为null");

    OperationStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
