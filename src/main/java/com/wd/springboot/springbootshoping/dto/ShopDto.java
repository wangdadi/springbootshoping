package com.wd.springboot.springbootshoping.dto;

import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

/**
 * ClassName:ShopDto
 * Package:com.wd.springboot.springbootshoping.dto
 * Description:
 * 数据传输对象   shop对象的传输
 * 存储店铺信息和状态值
 * @Date:2019/5/7 0007 13:55
 * @Author:王迪
 */
@Data
public class ShopDto {
    /**
     * 状态值
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 店铺数量
     */
    private int count;
    /**
     * 店铺 CRUD时使用
     */
    private Shop shop;
    /**
     * 查询时返回的店铺列表信息
     */
    private List<Shop> shopList;

    public ShopDto() {
    }

    public ShopDto(ShopStateEnum stateEnum,Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop=shop;
    }
    public ShopDto(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
}
