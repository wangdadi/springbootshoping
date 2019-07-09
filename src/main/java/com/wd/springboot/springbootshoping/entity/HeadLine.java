package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:HeadLine
 * Package:entity
 * Description:
 * 头条实体类
 * @Date:2019/4/27 0027 18:00
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class HeadLine {
    /**
     * 头条Id
     */
    private Long lineId;
    /**
     * 头条名称
     */
    private String lineName;
    /**
     * 头条链接
     */
    private String lineLink;
    /**
     * 头条轮播图片
     */
    private String lineImg;
    /**
     * 头条权重
     */
    private String  priority;
    /**
     * 头条状态 0不可用 1可用
     */
    private Integer enableStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
