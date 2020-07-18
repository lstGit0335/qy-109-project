package com.aaa.lwl.service;

import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wyh
 * date 2020-07-17
 */
@Service
public interface IUserService {
    @PostMapping("/allUser")
    ResultData selectAllUser (@RequestBody User user);
}
