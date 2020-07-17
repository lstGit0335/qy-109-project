package com.aaa.lwl.service;

import com.aaa.lwl.properties.FtpProperties;
import com.aaa.lwl.utils.FileNameUtils;
import com.aaa.lwl.utils.FtpUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.lwl.staticproperties.RedisProperties.POINT;
import static com.aaa.lwl.staticproperties.TimeForatProperties.DATE_FORMAT;

/**
 * fileName:UploadService
 * Author:李守堂
 * createTime:2020/7/13   15:00
 * version:1.0.0
 * Description
 */

@Service
public class UploadService {
    @Autowired
    private FtpProperties ftpProperties;

    /**
     * 文件上传
     * @param file
     * @return
     */
    public Boolean upload(MultipartFile file){
        //获取文件的远程名称，文件后缀名
        String oleFileName = file.getOriginalFilename();
        //生成新的文件名
        String newFileName = FileNameUtils.getFileName();
        //截取后缀名，拼接到新的文件名上
        newFileName = newFileName + oleFileName.substring(oleFileName.lastIndexOf(POINT));
        //获取文件上传路径
        String filePath = DateUtil.formatDate(new Date(),DATE_FORMAT);

        //使用文件上传工具类
        try {
            return FtpUtils.upload(ftpProperties.getHost(),ftpProperties.getPort(),ftpProperties.getUsername(),ftpProperties.getPassword(),ftpProperties.getBasePath(),filePath,newFileName,file.getInputStream());

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

}
