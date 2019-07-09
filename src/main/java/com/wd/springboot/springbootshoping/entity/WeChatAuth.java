package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:com.wd.ssm.entity.WeChatAuth
 * Package:PACKAGE_NAME
 * Description:
 * 微信账号 实体类
 * @Date:2019/4/27 0027 16:33
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class WeChatAuth {
    /**
     * 微信Id
     */
    private String weChatAuthId;
    /**
     * openId
     */
    private String openId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 关联用户信息表
     */
    private PersonInfo personInfo;
}
