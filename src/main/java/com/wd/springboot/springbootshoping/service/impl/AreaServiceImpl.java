package com.wd.springboot.springbootshoping.service.impl;

import com.wd.springboot.springbootshoping.dao.AreaDao;
import com.wd.springboot.springbootshoping.entity.Area;
import com.wd.springboot.springbootshoping.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:AreaServiceImpl
 * Package:com.wd.ssm.service.impl
 * Description:
 * 区域列表Service层
 * @Date:2019/5/2 0002 18:49
 * @Author:王迪
 */
@Service
@Slf4j
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    /**
     * 查询区域列表信息
     * @return areaList
     */
    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }
}
