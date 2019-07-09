package com.wd.springboot.springbootshoping.service;

import com.wd.springboot.springbootshoping.entity.Area;

import java.util.List;

/**
 * ClassName:AreaService
 * Package:com.wd.ssm.service.impl
 * Description:
 *  区域列表Service层
 * @Date:2019/5/2 0002 18:49
 * @Author:王迪
 */
public interface AreaService {
    /**
     * 查询区域列表信息
     * @return areaList
     */
    List<Area> queryArea();
}
