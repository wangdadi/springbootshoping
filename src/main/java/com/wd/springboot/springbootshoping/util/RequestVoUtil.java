package com.wd.springboot.springbootshoping.util;

import com.wd.springboot.springbootshoping.vo.RequestVo;

/**
 * ClassName:RequestVoUtil
 * Package:com.wd.ssm.util
 * Description:
 * RequestVo工具类
 * @Date:2019/5/2 0002 19:36
 * @Author:王迪
 */
public class RequestVoUtil {
    /**
     * 成功返回的数据
     * @param o
     * @return
     */
    public static RequestVo success(Object o){
        RequestVo requestVo=new RequestVo();
        requestVo.setCode(200);
        requestVo.setMessage("成功");
        requestVo.setData(o);
        return requestVo;
    }
    public static RequestVo success(){
        return success(null);
    }

    /**
     * 失败返回的数据
     * @param code  状态码
     * @param msg   消息
     * @return
     */
    public static RequestVo error(Integer code,String msg){
        RequestVo requestVo=new RequestVo();
        requestVo.setMessage(msg);
        requestVo.setCode(code);
        return requestVo;
    }
}
