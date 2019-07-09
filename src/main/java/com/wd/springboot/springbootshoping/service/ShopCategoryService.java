package com.wd.springboot.springbootshoping.service;

import com.wd.springboot.springbootshoping.entity.ShopCategory;

import java.util.List;

/**
 * ClassName:ShopCategoryService
 * Package:com.wd.springboot.springbootshoping.service
 * Description:
 * 店铺类别Service
 * @Date:2019/5/26 0026 19:16
 * @Author:王迪
 */
public interface ShopCategoryService {
    /**
     * 查询店铺类别
     * @param shopCategory
     * @return
     */
    List<ShopCategory> findShopCategory(ShopCategory shopCategory);
}
