package com.wd.springboot.springbootshoping.service.impl;

import com.wd.springboot.springbootshoping.dto.ShopDto;
import com.wd.springboot.springbootshoping.entity.Area;
import com.wd.springboot.springbootshoping.entity.PersonInfo;
import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.entity.ShopCategory;
import com.wd.springboot.springbootshoping.enums.ShopStateEnum;
import com.wd.springboot.springbootshoping.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
/**
 * ClassName:ShopServiceImplTest
 * Package:com.wd.springboot.springbootshoping.service.impl
 * Description:
 *
 * @Date:2019/5/12 0012 15:39
 * @Author:王迪
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceImplTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void addShop() throws FileNotFoundException {
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
        shop.setShopName("测试店铺1");
        shop.setPhone("test");
        shop.setPriority(1);
        shop.setAdvice("审核中");
        shop.setEnableStatus(ShopStateEnum.NEWSHOP.getState());
        shop.setCreateTime(new Date());
        shop.setUpdateTime(shop.getCreateTime());
        File shopImage=new File("D:\\1.jpg");
        InputStream is=new FileInputStream(shopImage);
        ShopDto shopDto = shopService.addShop(shop,is,shopImage.getName());
        Assert.assertEquals(ShopStateEnum.NEWSHOP.getState(),shopDto.getState());
    }
    @Test
    public void updateShop() throws FileNotFoundException{
        Shop shop=new Shop();
        shop.setShopId(14L);
        shop.setShopName("测试店铺修改");
        File shopImage=new File("E:\\测试修改.png");
        InputStream is=new FileInputStream(shopImage);
        ShopDto shopDto = shopService.updateShop(shop, is, "测试修改.png");
        System.out.println("新的图片地址为:"+shopDto.getShop().getShopImg());
    }
}