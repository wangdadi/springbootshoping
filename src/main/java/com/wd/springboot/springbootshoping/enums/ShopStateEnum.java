package com.wd.springboot.springbootshoping.enums;

import lombok.Getter;

/**
 * ClassName:ShopStateEnum
 * Package:com.wd.springboot.springbootshoping.enums
 * Description:
 * 店铺状态值对应信息
 * @Date:2019/5/7 0007 20:34
 * @Author:王迪
 */
@Getter
public enum ShopStateEnum {
    NEWSHOP(0,"商铺审核中"),
    OFFLINE(-1,"下线商铺"),
    SUCCESS(1,"操作成功"),
    PASS(2,"审核通过"),
    INNER_ERROR(10000,"系统内部错误"),
    NULL_SHOP(10001,"店铺信息为空");
    private int state;
    private String stateInfo;

    ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    /**
     * 根据对应的state值返回对应信息
     */
    public static ShopStateEnum statef(int state){
        for (ShopStateEnum stateEnum:values()) {
            if (stateEnum.getState()==state){
                return stateEnum;
            }
        }
        return null;
    }
}
