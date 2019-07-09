package com.wd.springboot.springbootshoping.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName:com.wd.ssm.entity.Area
 * Package:PACKAGE_NAME
 * Description:
 * 区域实体类
 * @Date:2019/4/26 0026 23:30
 * @Author:王迪
 */
@Data
@ToString(callSuper = true)
public class Area {
    /**
     * 区域Id
     */
    private Integer areaId;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 权重 权重越大排名越前
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
