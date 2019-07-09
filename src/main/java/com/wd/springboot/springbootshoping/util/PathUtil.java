package com.wd.springboot.springbootshoping.util;

/**
 * ClassName:PathUtil
 * Package:com.wd.springboot.springbootshoping.util
 * Description:
 * 定义图片的路径 根据操作系统的不同定义不同的路径
 * @Date:2019/5/6 0006 20:35
 * @Author:王迪
 */
public class PathUtil {
    /**
     * 系统文件分隔符（在 UNIX 系统中是“/”）file.separator
     */
    private static String seperator=System.getProperty("file.separator");
    public static String getImageBasePath(){
        /**
         * 获取操作系统的名称
         */
        String os = System.getProperty("os.name");
        String basePath="";
        if(os.toLowerCase().startsWith("win")){
            basePath="D:\\springbootImg";
        }else {
            basePath="/home/wd/image";
        }
        /**
         * 统一处理 / 问题
         */
        basePath.replace("/",seperator);
        return basePath;
    }

    /**
     * 获取店铺图片的路径 不同店铺不同图片
     * @return
     */
    public static String getShopImagePath(long shopId){
       String imagePath="\\upload\\item\\shop"+shopId+"\\";
       imagePath.replace("\\",seperator);
       return imagePath;
    }
}
