package com.aaa.lwl.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * fileName:ResultData
 * Author:李守堂
 * createTime:2020/7/8   15:38
 * version:1.0.0
 * Description
 */
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;




}
