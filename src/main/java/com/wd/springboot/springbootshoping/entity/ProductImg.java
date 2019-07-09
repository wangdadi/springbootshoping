package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:ProductImg
 * Package:entity
 * Description:
 * 商品详情图片实体类
 * @Date:2019/4/27 0027 20:26
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class ProductImg {
    /**
     * 商品详情图片Id
     */
    private Long productImgId;
    /**
     * 商品详情图片地址
     */
    private String imgAddress;
    /**
     * 商品详情图片描述
     */
    private String imgDesc;
    /**
     * 商品详情图片权重
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 商品Id
     */
    private Long productId;
}
