package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName:ShopCategoryDaoTest
 * Package:com.wd.springboot.springbootshoping.dao
 * Description:
 *
 * @Date:2019/5/25 0025 0:10
 * @Author:王迪
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryDaoTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void findShopCategory() {
        List<ShopCategory> shopCategoryList=shopCategoryDao.findShopCategory(new ShopCategory());
        System.out.println("+++++++++++++++++++++++"+shopCategoryList);
        Assert.assertEquals(1,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}