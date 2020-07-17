package com.aaa.lwl.service;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.model.User;
import com.aaa.lwl.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * fileName:LoginService
 * Author:李守堂
 * createTime:2020/7/15   16:22
 * version:1.0.0
 * Description
 */
@Service
public class LoginService  extends BaseService<User> {

    public TokenVo doLogin(User user){
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();

        //判断user是否为空
        if (null != user){
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            //【判断user2是否为空
            if (null == user2){
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            }else {
                //用户名OK，查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                //判断user3是否为空
                if (null == user3){
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                }else {
                    //登录成功
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    user3.setToken(token);

                    Integer updateResult = super.update(user3);
                    if (updateResult > 0){
                        tokenVo.setIfSuccess(true).setToken(token);
                    }else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }

        }else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }
}
