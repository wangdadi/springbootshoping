package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.Area;

import java.util.List;

/**
 * ClassName:AreaDao
 * Package:com.wd.ssm.dao
 * Description:
 * 区域列表Dao层
 * @Date:2019/5/1 0001 17:31
 * @Author:王迪
 */
public interface AreaDao {
    /**
     * 查询区域列表信息
     * @return areaList
     */
    List<Area> queryArea();

}
