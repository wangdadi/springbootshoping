package com.wd.springboot.springbootshoping.dao;

import com.wd.springboot.springbootshoping.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName:AreaDaoTest
 * Package:com.wd.springboot.springbootshoping.dao
 * Description:
 *
 * @Date:2019/6/27 0027 0:37
 * @Author:王迪
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void findArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }
}