package com.wd.springboot.springbootshoping.vo;

import lombok.Data;

/**
 * ClassName:RequestVo
 * Package:com.wd.ssm.vo
 * Description:
 * 前端返回的Vo对象
 * @Date:2019/5/2 0002 19:17
 * @Author:王迪
 */
@Data
public class RequestVo<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * data对象
     */
    private T data;
}
