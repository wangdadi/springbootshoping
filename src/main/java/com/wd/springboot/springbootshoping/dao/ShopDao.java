package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.Shop;

/**
 * ClassName:ShopDao
 * Package:com.wd.springboot.springbootshoping.dao
 * Description:
 * 店铺Dao层
 * @Date:2019/5/5 0005 15:01
 * @Author:王迪
 */
public interface ShopDao {
    /**
     * 新增店铺信息
     * @param shop
     * @return
     */
    Integer insertShop(Shop shop);

    /**
     * 修改店铺信息
     * @param shop
     * @return
     */
    Integer updateShop(Shop shop);

    /**
     * 根据店铺Id查询店铺信息
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
}
