package com.aaa.lwl.utils;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/**
 * fileName:StringUtils
 * Author:李守堂
 * createTime:2020/7/10   15:44
 * version:1.0.0
 * Description
 */
public class StringUtils {


    /**
     * MD5
     * @param str
     * @return
     */
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 杀空函数 将"null" 和null对象转换为""
     * @param str
     * @return
     */
    public static String killNull(String str){
        String returnStr;
        if (str == null ||"null".equalsIgnoreCase(str)){
            returnStr = "";
        }else {
            returnStr = str;
        }
        return returnStr;
    }

    /**
     * 去除字符串两边的空格并处理空字符串
     * @param str
     * @return
     */
    public static  String trim(String str){
        String returnStr;
        returnStr = killNull(str);
        returnStr = returnStr.trim();
        return returnStr;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }

    /**
     * 判断字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 获取指定长度的随机字母和数组组合
     * @param length
     * @return
     */
    public static String getCharAndNum(int length){
        String str = "";
        Random random = new Random();

        for (int i = 0; i < length; i++){
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)){
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str += (char)(choice + random.nextInt(26));
            }else if ("num".equalsIgnoreCase(charOrNum)){
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    /**
     * 将byte[]数组转化为base64文本
     * @param decByte
     * @return
     * @throws Exception
     */
    public static final String byteToBase64(byte[] decByte) throws Exception{
        if (decByte == null)
            return "";
            String str = "";

        try{
            str = new BASE64Encoder().encodeBuffer(decByte);

        }catch (Exception e){
            str = "";
        }
        return str.replace("\t" ,"").replace("\n","");

    }


    /**
     * 将base64文本转换为byte[]数组
     * @param str
     * @return
     * @throws Exception
     */
    public static final byte[] base64ToByte(String str)throws Exception{
        if (str == null)
            return null;
        byte[] decByte = null;
        try {
            decByte = new sun.misc.BASE64Decoder().decodeBuffer(str);
        }catch (Exception e){
            decByte = null;
        }
        return decByte;
    }

    /**
     *
     * 将ErrorsStack转化为String
     * @param throwable
     * @return
     */
    public static String getExceptionAsString(Throwable throwable){
        if (throwable == null){
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}

