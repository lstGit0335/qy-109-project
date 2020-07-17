package com.aaa.lwl.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author 王宇航
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //链式调用
public class BaseModel {

    @Id
    @NotNull
    private Long id;

    @Column(name = "create_time")
    @Max(value = 100,message = "时间长度最大不能超过100")
    private String createTime;

    @Column(name = "modify_time")
    @Max(value = 100,message = "时间长度最大不能超过100")
    private String modifyTime;



}



