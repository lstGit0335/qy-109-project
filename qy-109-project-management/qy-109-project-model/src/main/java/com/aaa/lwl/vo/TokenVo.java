package com.aaa.lwl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * fileName:TokenVo
 * Author:李守堂
 * createTime:2020/7/15   16:24
 * version:1.0.0
 * Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TokenVo  implements Serializable {
    private String token;
    private Boolean ifSuccess;
    /**
     * 1.账号不存在
     * 2.密码不存在
     * 3.账号被锁定
     * 4.系统异常
     */
    private Integer type;
}
