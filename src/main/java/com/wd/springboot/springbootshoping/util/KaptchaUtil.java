package com.wd.springboot.springbootshoping.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:KaptchaUtil
 * Package:com.wd.springboot.springbootshoping.util
 * Description:
 * 判断验证码是否正确
 * @Date:2019/6/2 0002 17:01
 * @Author:王迪
 */
public class KaptchaUtil {
    public static boolean checkKaptcha(HttpServletRequest request){
        /**
         * 图片中验证码
         */
        String expectedKaptcha=(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        /**
         * 输入的验证码
         */
        String actualKaptcha=HttpServletRequestUtil.getString(request,"actualKaptcha");
        if (actualKaptcha==null || !actualKaptcha.equals(expectedKaptcha)){
            return false;
        }
        return true;
    }
}
