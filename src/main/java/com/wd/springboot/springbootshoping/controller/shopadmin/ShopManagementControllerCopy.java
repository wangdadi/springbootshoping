/*
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
import com.wd.springboot.springbootshoping.util.FileUtil;
import com.wd.springboot.springbootshoping.util.HttpServletRequestUtil;
import com.wd.springboot.springbootshoping.util.ImageUtil;
import com.wd.springboot.springbootshoping.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * ClassName:ShopManagementController
 * Package:com.wd.springboot.springbootshoping.controller.shopadmin
 * Description:
 * 店铺管理员controller层
 * @Date:2019/5/12 0012 20:08
 * @Author:王迪
 *//*

@RestController
@RequestMapping("/shopAdmin")
public class ShopManagementControllerCopy {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    */
/**
     * 初始化店铺列表和区域列表
     * @return
     *//*

    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    public Map<String,Object> getshopinitinfo(){
        Map<String,Object> map=new HashMap<>(16);
        try {
            List<ShopCategory> shopCategoryList = shopCategoryService.findShopCategory(new ShopCategory());
            List<Area> areaList = areaService.findArea();
            map.put("shopCategoryList",shopCategoryList);
            map.put("areaList",areaList);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("errorMassage",e.getMessage());
        }
        return map;
    }

    */
/**
     * 注册店铺
     * @param request
     * @return
     *//*

    @RequestMapping(value = "/registerShop",method = RequestMethod.POST)
    public Map<String,Object> registerShop(HttpServletRequest request){
        */
/**
         * 接收并参数并转换
         *//*

        Map<String,Object> map=new HashMap<>(16);
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
        */
/**
         * 获取上传图片
         *//*

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
        */
/**
         * 注册店铺
         *//*

        if (shop!=null && shopImg!=null){
            PersonInfo personInfo=new PersonInfo();
            //Session TODO
            personInfo.setUserId(1L);
            shop.setPersonInfo(personInfo);
            File shopImgFile=new File(PathUtil.getImageBasePath()+ImageUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            } catch (IOException e) {
                map.put("success",false);
                map.put("error",e.getMessage());
                return map;
            }
            try {
                FileUtil.inputStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                map.put("success",false);
                map.put("error",e.getMessage());
                return map;
            }
            ShopDto shopDto = shopService.addShop(shop, shopImgFile);
            if (shopDto.getState() == ShopStateEnum.NEWSHOP.getState()){
                map.put("success",true);
            }else {
                map.put("success",false);
                map.put("error",shopDto.getStateInfo());
            }
            return map;
        }else {
            map.put("success",false);
            map.put("error","请输入店铺信息");
            return map;
        }
    }
}
*/
