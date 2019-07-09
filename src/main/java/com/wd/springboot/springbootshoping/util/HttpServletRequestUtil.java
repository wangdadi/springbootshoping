package com.wd.springboot.springbootshoping.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:HttpServletRequestUtil
 * Package:com.wd.springboot.springbootshoping.util
 * Description:
 * 解析HttpServletRequest中的参数
 * @Date:2019/5/12 0012 20:34
 * @Author:王迪
 */
public class HttpServletRequestUtil {
    public static Integer getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static Long getLong(HttpServletRequest request,String key){
        try {
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1L;
        }
    }
    public static Double getDouble(HttpServletRequest request,String key){
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1D;
        }
    }
    public static String  getString(HttpServletRequest request,String key){
        try {
             String result=request.getParameter(key);
             if (result!=null){
                 result=result.trim();
             }
             if ("".equals(result)){
                 result=null;
             }
             return result;
        }catch (Exception e){
             return null;
        }
    }
}
