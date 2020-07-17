package com.aaa.lwl.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * fileName:JSONUtils
 * Author:李守堂
 * createTime:2020/7/10   15:30
 * version:1.0.0
 * Description
 */
public class JSONUtils {
    private  static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 把对象转化json字符串
     * @param object
     * @return
     */
    public static  String toJsonString(Object object){
        try {
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 吧json转化为指定对象
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonData,Class<T> beanType){

        try {
            OBJECT_MAPPER.readValue(jsonData,beanType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 吧json转化为List集合
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List <T> toList(String jsonData,Class<T> beanType){
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
