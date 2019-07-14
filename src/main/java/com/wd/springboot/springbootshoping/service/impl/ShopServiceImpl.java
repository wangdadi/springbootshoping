package com.wd.springboot.springbootshoping.service.impl;

import com.wd.springboot.springbootshoping.dao.ShopDao;
import com.wd.springboot.springbootshoping.dto.ShopDto;
import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.enums.ShopStateEnum;
import com.wd.springboot.springbootshoping.exception.ServiceException;
import com.wd.springboot.springbootshoping.service.ShopService;
import com.wd.springboot.springbootshoping.util.ImageUtil;
import com.wd.springboot.springbootshoping.util.PathUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/**
 * ClassName:ShopServiceImpl
 * Package:com.wd.springboot.springbootshoping.service.impl
 * Description:
 * 店铺信息ServiceImpl
 * @Date:2019/5/12 0012 14:15
 * @Author:王迪
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    /**
     * 根据店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    @Override
    public Shop queryByShopId(long shopId) {

        return shopDao.queryByShopId(shopId);
    }

    /**
     * 更新店铺信息
     *
     * @param shop                 店铺信息
     * @param shopImageInputStream 更新店铺图片
     * @param fileName             图片名
     * @return
     * @throws ServiceException
     */
    @Override
    public ShopDto updateShop(Shop shop, InputStream shopImageInputStream, String fileName) throws ServiceException {
        if (shop==null || shop.getShopId()==null){
            return new ShopDto(ShopStateEnum.NULL_SHOP);
        }else {
            try {
                //判断是是否有图片操作
                if(shopImageInputStream!=null && fileName!=null &&!"".equals(fileName)){
                    Shop shop1 = shopDao.queryByShopId(shop.getShopId());
                    if (shop1.getShopImg()!=null){
                        ImageUtil.deleteFileOrPath(shop1.getShopImg());
                    }
                    addShopImage(shop,shopImageInputStream,fileName);
                }
                //更新店铺信息
                shop.setCreateTime(new Date());
                shop.setUpdateTime(shop.getCreateTime());
                Integer result = shopDao.updateShop(shop);
                if (result<=0){
                    return new ShopDto(ShopStateEnum.INNER_ERROR);
                }else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopDto(ShopStateEnum.SUCCESS,shop);
                }
            }catch (Exception e){
                throw new ServiceException("更新失败"+e.getMessage());
            }
        }
    }

    /**
     * 添加店铺
     * @param shop      店铺实体类
     * @param shopImageInputStream 店铺图片
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public ShopDto addShop(Shop shop, InputStream shopImageInputStream,String fileName) {
        if(shop==null){
            return new ShopDto(ShopStateEnum.NULL_SHOP);
        }
        /**
         * 添加店铺信息
         */
        try{
            shop.setEnableStatus(0);
            shop.setPriority(0);
            shop.setCreateTime(new Date());
            shop.setUpdateTime(new Date());
            Integer result = shopDao.insertShop(shop);
            if (result<=0){
                throw new ServiceException("添加店铺信息失败");
            }else {
                /**
                 * 添加店铺图片信息
                 */
                if (shopImageInputStream!=null) {
                    try {
                        addShopImage(shop, shopImageInputStream,fileName);
                    } catch (ServiceException e) {
                        throw new ServiceException("addShopImage:error" + e.getMessage());
                    }

                    /**
                     * 更新图片地址信息
                     */
                    result = shopDao.updateShop(shop);
                    if (result <= 0) {
                        throw new ServiceException("更新图片地址失败");
                    }
                }
            }
        }catch (ServiceException e){
            throw new ServiceException("addShop:error"+e.getMessage());
        }
        return new ShopDto(ShopStateEnum.NEWSHOP,shop);
    }

    private void addShopImage(Shop shop, InputStream shopImageInputStream,String fileName) {
        /**
         * 获取店铺图片相对路径
         */
        String dest= PathUtil.getShopImagePath(shop.getShopId());
        String shopImageAddress= ImageUtil.generateThumbnail(shopImageInputStream,fileName,dest);
        shop.setShopImg(shopImageAddress);
    }
}
