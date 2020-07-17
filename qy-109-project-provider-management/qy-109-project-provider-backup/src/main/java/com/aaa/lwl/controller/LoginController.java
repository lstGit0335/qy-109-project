package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.User;
import com.aaa.lwl.service.LoginService;
import com.aaa.lwl.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.lwl.status.LoginStatus.*;

/**
 * fileName:LoginController
 * @Author:李守堂
 * createTime:2020/7/15   16:39
 * version:1.0.0
 * Description
 */
@RestController
public class LoginController extends CommonController<User> {


    @Autowired
    private LoginService loginService;

    @Override
    public BaseService<User> getBaseService() {
        return loginService;
    }

    /**
     * 执行登录操作
     * @param user
     * @return
     */

    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = loginService.doLogin(user);

        if (tokenVo.getIfSuccess()){
            return super.loginSuccess(tokenVo.getToken());
        }else if (tokenVo.getType() == 1){
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if(tokenVo.getType() == 2){
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }
}
