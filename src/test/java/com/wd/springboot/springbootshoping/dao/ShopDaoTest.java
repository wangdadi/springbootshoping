package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.Area;
import com.wd.springboot.springbootshoping.entity.PersonInfo;
import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;

/**
 * ClassName:ShopDaoTest
 * Package:com.wd.springboot.springbootshoping.dao
 * Description:
 *
 * @Date:2019/5/5 0005 18:05
 * @Author:王迪
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    //@Ignore
    public void insertShop(){
        Shop shop=new Shop();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        PersonInfo personInfo=new PersonInfo();
        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setPersonInfo(personInfo);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test");
        shop.setPhone("test");
        shop.setPriority(1);
        shop.setAdvice("test");
        shop.setEnableStatus(1);
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setUpdateTime(shop.getCreateTime());
        Integer result = shopDao.insertShop(shop);
        System.out.println(result);
        Assert.assertEquals(1,(long)result);
    }
    @Test
    //@Ignore
    public void updateShop(){
        Shop shop=new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改");
        shop.setPhone("123456789");
        shop.setAdvice("修改");
        shop.setShopImg("D:\\1.jpg");
        shop.setUpdateTime(new Date());
        Integer result = shopDao.updateShop(shop);
        Assert.assertEquals(1,(long)result);
    }
    @Test
    public void queryByShopId(){
        long shopId=1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getArea().getAreaName());
        System.out.println(shop.getShopCategory().getShopCategoryName());
        System.out.println(shop.getShopCategory().getShopCategoryId());
    }
}
