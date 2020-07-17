package com.aaa.lwl.utils;

import java.util.Random;

/**
 * fileName:FileNameUtils
 * Author:李守堂
 * createTime:2020/7/10   16:33
 * version:1.0.0
 * Description
 */
public class FileNameUtils {
    private FileNameUtils(){

    }

    public static String getFileName(){
        //1.获取当前系统时间的毫秒数
        long currentTimeMills = System.currentTimeMillis();
        //2.创建随机数对象
        Random random = new Random();
        //3.随机从0-999之间随机
        int number = random.nextInt(999);
           //4.生成最终文件名
        return currentTimeMills + String.format("%03d",number);
    }
}
