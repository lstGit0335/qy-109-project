package com.aaa.lwl.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * fileName:SpringContextUtils
 * Author:李守堂
 * createTime:2020/7/9   15:30
 * version:1.0.0
 * Description
 */
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT = null;
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();
    private SpringContextUtils(){

    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        SpringContextUtils.APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        Lock lock = READ_WRITE_LOCK.readLock();
        lock.lock();
        try {
            if (null != APPLICATION_CONTEXT){
                return APPLICATION_CONTEXT;
            }else {
                return null;
            }
        }finally {
            lock.unlock();
        }
    }
}
