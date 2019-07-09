package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:com.wd.ssm.entity.PersonInfo
 * Package:PACKAGE_NAME
 * Description:
 * 用户信息表   关联关系WeChatAuth LocalAuth
 * @Date:2019/4/27 0027 0:35
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class PersonInfo {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户头像地址
     */
    private String profileImg;
    /**
     * 用户邮箱地址
     */
    private String email;
    /**
     * 用户性别
     */
    private String gender;
    /**
     * 用户状态  启用 禁用
     */
    private Integer enableStatus;
    /**
     * 用户身份标识
     * 1.顾客
     * 2.店家
     * 3.超级管理员
     */
    private Integer userType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
