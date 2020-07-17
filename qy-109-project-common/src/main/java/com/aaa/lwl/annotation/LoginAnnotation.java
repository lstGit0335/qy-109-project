package com.aaa.lwl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * fileName:LoginAnnotation
 * @Author:李守堂
 * createTime:2020/7/15   14:31
 * version:1.0.0
 * Description
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {

    /**
     * 要执行的操作类型:
     *      eg:
     *          delete操作，update操作，insert操作...
     * @return
     */
    String opeationType();

    /**
     * 所要执行的具体操作内容
     *      eg:
     *          删除用户，删除菜单，删除部门...
     * @return
     */
    String opeationName();
}
