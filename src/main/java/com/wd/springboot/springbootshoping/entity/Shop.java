package com.wd.springboot.springbootshoping.entity;


import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:Shop
 * Package:entity
 * Description:
 * 店铺表实体类
 * @Date:2019/4/27 0027 18:59
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class Shop {
    /**
     * 店铺Id
     */
    private Long shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺描述
     */
    private String shopDesc;
    /**
     * 店铺地址
     */
    private String shopAddress;
    /**
     * 店铺联系方式
     */
    private String phone;
    /**
     * 店铺图片
     */
    private String shopImg;
    /**
     * 店铺权重
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 店铺状态 -1不可用 0审核中 1可用
     */
    private Integer enableStatus;
    /**
     * 超级管理员给店铺建议
     */
    private String advice;
    /**
     * 店铺对应某个区域
     */
    private Area area;
    /**
     * 店铺对应某个应用户
     */
    private PersonInfo personInfo;
    /**
     * 店铺对应某个店铺类别
     */
    private ShopCategory shopCategory;
}