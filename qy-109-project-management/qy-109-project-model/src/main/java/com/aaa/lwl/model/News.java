package com.aaa.lwl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_news")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 正文摘要
     */
    private String digest;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 记录最近一次修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 正文
     */
    private String body;


}