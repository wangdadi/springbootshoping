package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:ShopCategory
 * Package:entity
 * Description:
 * 店铺类别实体类
 * @Date:2019/4/27 0027 18:26
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class ShopCategory {
    /**
     * 店铺类别Id
     */
    private Long shopCategoryId;
    /**
     * 店铺类别名称
     */
    private String shopCategoryName;
    /**
     * 店铺类别描述
     */
    private String shopCategoryDesc;
    /**
     * 店铺类别图片地址
     */
    private String shopCategoryImg;
    /**
     * 店铺类别权重
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
     * 上级Id  如果为空则为上级Id  如果不为空则为二级Id
     */
    private ShopCategory shopParentId;
}
