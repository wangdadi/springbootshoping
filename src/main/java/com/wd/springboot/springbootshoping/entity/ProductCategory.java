package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:ProductCategory
 * Package:entity
 * Description:
 * 商品类别实体类
 * @Date:2019/4/27 0027 20:06
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class ProductCategory {
    /**
     * 商品类别Id
     */
    private Long productCategoryId;
    /**
     * 店铺Id
     */
    private Long shopId;
    /**
     * 商品类别名称
     */
    private String productCategoryName;
    /**
     * 商品类别权重
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
}
