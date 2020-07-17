package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.model.LoginLog;
import com.aaa.lwl.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:LoginLogController
 * Author:李守堂
 * createTime:2020/7/15   16:40
 * version:1.0.0
 * Description
 */
@RestController
public class LoginLogController extends CommonController<LoginLog> {
  @Autowired
  private LoginLogService loginLogService;


    @Override
    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }

    /**
     * 保存日志
     * @param loginLog
     * @return
     */
    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLog loginLog){
        return getBaseService().add(loginLog);
    }
}
