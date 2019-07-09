package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:LocalAuth
 * Package:entity
 * Description:
 * 本地账号
 * @Date:2019/4/27 0027 17:06
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class LocalAuth {
    /**
     * 本地账号Id
     */
    private Long localAuthId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 关联用户信息表
     */
    private PersonInfo personInfo;
}
