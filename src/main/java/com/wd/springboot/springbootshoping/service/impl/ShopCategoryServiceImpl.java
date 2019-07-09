package com.wd.springboot.springbootshoping.service.impl;

import com.wd.springboot.springbootshoping.dao.ShopCategoryDao;
import com.wd.springboot.springbootshoping.entity.ShopCategory;
import com.wd.springboot.springbootshoping.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:ShopCategoryServiceImpl
 * Package:com.wd.springboot.springbootshoping.service.impl
 * Description:
 * 店铺类别Service
 * @Date:2019/5/26 0026 19:20
 * @Author:王迪
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    /**
     * 查询店铺类别
     * @param shopCategory
     * @return
     */
    @Override
    public List<ShopCategory> findShopCategory(ShopCategory shopCategory) {
        List<ShopCategory> shopCategoryList = shopCategoryDao.findShopCategory(shopCategory);
        return shopCategoryList;
    }
}
