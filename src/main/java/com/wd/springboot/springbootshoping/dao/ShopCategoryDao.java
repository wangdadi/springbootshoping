package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.ShopCategory;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:ShopCategoryDao
 * Package:com.wd.springboot.springbootshoping.dao
 * Description:
 * 店铺类别DAO层
 * @Date:2019/5/21 0021 23:03
 * @Author:王迪
 */
public interface ShopCategoryDao {
    /**
     * 根据店铺类别参数查询店铺信息
     * @param shopCategory
     * @return
     */
    List<ShopCategory> findShopCategory(@Param("shopCategory") ShopCategory shopCategory);

    /**
     * 添加区域列表信息
     * @param shopCategory
     * @return
     */
    int insertShopCategory(ShopCategory shopCategory);
}
