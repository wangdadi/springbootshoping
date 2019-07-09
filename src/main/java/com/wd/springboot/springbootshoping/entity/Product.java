package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Product
 * Package:entity
 * Description:
 * 商品表信息
 * @Date:2019/4/27 0027 20:46
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class Product {
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 商品简略图
     */
    private String imgAddress;
    /**
     * 商品原价
     */
    private String normalPrice;
    /**
     * 商品折扣价
     */
    private String promotionPrice;
    /**
     * 商品权重
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
     * 商品状态 0下架 1上架
     */
    private Integer enableStatus;
    /**
     * 商品对应详情图片 1-->n
     */
    private List<ProductImg> productImgList;
    /**
     * 商品对应商品类型
     */
    private ProductCategory productCategory;
    /**
     * 商品对应店铺
     */
    private Shop shop;

}
