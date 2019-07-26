package com.wd.springboot.springbootshoping.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wd.springboot.springbootshoping.dto.ShopDto;
import com.wd.springboot.springbootshoping.entity.Area;
import com.wd.springboot.springbootshoping.entity.PersonInfo;
import com.wd.springboot.springbootshoping.entity.Shop;
import com.wd.springboot.springbootshoping.entity.ShopCategory;
import com.wd.springboot.springbootshoping.enums.ShopStateEnum;
import com.wd.springboot.springbootshoping.service.AreaService;
import com.wd.springboot.springbootshoping.service.ShopCategoryService;
import com.wd.springboot.springbootshoping.service.ShopService;
import com.wd.springboot.springbootshoping.util.HttpServletRequestUtil;
import com.wd.springboot.springbootshoping.util.KaptchaUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ShopManagementController
 * Package:com.wd.springboot.springbootshoping.controller.shopadmin
 * Description:
 * 店铺管理员controller层
 * @Date:2019/5/12 0012 20:08
 * @Author:王迪
 */
@RestController
@RequestMapping("/shopAdmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    /**
     * 初始化店铺列表和区域列表
     * @return
     */
    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    public Map<String,Object> getshopinitinfo(){
        Map<String,Object> map=new HashMap<>(16);
        try {
            List<ShopCategory> shopCategoryList = shopCategoryService.findShopCategory(new ShopCategory());
            List<Area> areaList = areaService.queryArea();
            map.put("shopCategoryList",shopCategoryList);
            map.put("areaList",areaList);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("errorMassage",e.getMessage());
        }
        return map;
    }

    /**
     * 注册店铺
     * @param request
     * @return
     */
    @RequestMapping(value = "/registerShop",method = RequestMethod.POST)
    public Map<String,Object> registerShop(HttpServletRequest request){
        /**
         * 接收并参数并转换
         */
        Map<String,Object> map=new HashMap<>(16);
        if (!KaptchaUtil.checkKaptcha(request)){
            map.put("success",false);
            map.put("error","验证码错误");
            return map;
        }
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper objectMapper=new ObjectMapper();
        Shop shop=null;
        try {
            shop = objectMapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            map.put("success",false);
            map.put("error",e.getMessage());
            return map;
        }
        /**
         * 获取上传图片
         */
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver resolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断是否有文件上传
        if (resolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else {
            map.put("success",false);
            map.put("error","上传图片不能为空");
            return map;
        }
        /**
         * 注册店铺
         */
        if (shop!=null && shopImg!=null){
            PersonInfo personInfo=new PersonInfo();
            //Session TODO
            personInfo.setUserId(1L);
            shop.setPersonInfo(personInfo);
            ShopDto shopDto;
            try {
                shopDto = shopService.addShop(shop, shopImg.getInputStream(),shopImg.getOriginalFilename());
                if (shopDto.getState() == ShopStateEnum.NEWSHOP.getState()){
                    map.put("success",true);
                }else {
                    map.put("success",false);
                    map.put("error",shopDto.getStateInfo());
                }
            } catch (IOException e) {
                map.put("success",false);
                map.put("error",e.getMessage());
            }
            return map;
        }else {
            map.put("success",false);
            map.put("error","请输入店铺信息");
            return map;
        }
    }

    /**
     * 根据店铺Id查询店铺信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getShopId",method = RequestMethod.POST)
    public Map<String,Object> getShopById(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>(16);
        Long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        if (shopId>-1){
            try {
                Shop shop = shopService.queryByShopId(shopId);
                List<Area> areaList = areaService.queryArea();
                map.put("shop", shop);
                map.put("areaList", areaList);
                map.put("success", true);
            }catch (Exception e){
                map.put("error",false);
                map.put("错误信息",e.getMessage());
            }
        }else{
            map.put("error",false);
        }
        return map;
    }
}
