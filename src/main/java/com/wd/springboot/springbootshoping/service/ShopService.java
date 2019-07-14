package com.wd.springboot.springbootshoping.service;

import com.wd.springboot.springbootshoping.dto.ShopDto;
import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.exception.ServiceException;

import java.io.InputStream;

/**
 * ClassName:ShopService
 * Package:com.wd.springboot.springbootshoping.service
 * Description:
 * 店铺service
 * @Date:2019/5/12 0012 14:12
 * @Author:王迪
 */
public interface ShopService {
    /**
     * 添加店铺
     * @param shop  店铺实体类
     * @param shopImageInputStream 店铺图片
     * @return
     */
    ShopDto addShop(Shop shop, InputStream shopImageInputStream,String fileName) throws ServiceException;

    /**
     * 根据店铺Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 更新店铺信息
     * @param shop  店铺信息
     * @param shopImageInputStream  更新店铺图片
     * @param fileName  图片名
     * @return
     * @throws ServiceException
     */
    ShopDto updateShop(Shop shop, InputStream shopImageInputStream,String fileName) throws ServiceException;
}
