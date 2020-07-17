package com.aaa.lwl.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * fileName:Map2BeanUtils
 * Author:李守堂
 * createTime:2020/7/9   14:57
 * version:1.0.0
 * Description
 */
public class Map2BeanUtils {

    private Map2BeanUtils(){

    }
    //高性能Java实例化工具类
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    //使用String效率太低，使用StingBuffer效率提高了但是不如stringBuilder
    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP =
            new ConcurrentHashMap<Class, MethodAccess>(16);


    public static <T> T map2Bean(Map<String ,Object> map,Class<T> clazz){
        //获取实例对象信息
        T instance = OBJENESIS.newInstance(clazz);
        //从map中通过key（instance），或者MethodAccess对象
        MethodAccess methodAccess =CONCURRENT_HASH_MAP.get(clazz);
        //判断
        if (null == methodAccess){
            //通过类获取methodAccess对象
            methodAccess = MethodAccess.get(clazz);
            //存入CONCURRENT_HASH_MAP中
            CONCURRENT_HASH_MAP.putIfAbsent(clazz,methodAccess);
        }
        //循环map对象
        for (Map.Entry entry : map.entrySet()){


            String setMethodName = getSetMethodName((String)entry.getKey());
            int index = methodAccess.getIndex(setMethodName,entry.getValue().getClass());
            methodAccess.invoke(instance,index,entry.getValue());
        }
        return instance;
    }

    /**
     * 通过字段拼接方法名
     * @param filedName
     * @return
     */
    private static String getSetMethodName(String filedName) {
        STRING_BUILDER.setLength(0);
        return STRING_BUILDER.append("set").append(first2UpperCase(filedName)).toString();
    }

    /**
     * 把属性的首字母转换为大写
     * @param str
     * @return
     */
    private static String first2UpperCase(String str) {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
