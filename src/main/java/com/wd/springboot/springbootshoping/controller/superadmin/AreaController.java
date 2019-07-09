package com.wd.springboot.springbootshoping.controller.superadmin;

import com.wd.springboot.springbootshoping.entity.Area;
import com.wd.springboot.springbootshoping.exception.ServiceException;
import com.wd.springboot.springbootshoping.service.AreaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:AreaController
 * Package:com.wd.ssm.controller
 * Description:
 * 区域列表Controller层
 * @Date:2019/5/2 0002 19:13
 * @Author:王迪
 */
@RestController
@RequestMapping("/superAdmin")
@Slf4j
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    public Map<String,Object> listArea(){
        log.info("++++++start++++++++++");
        long startTime=System.currentTimeMillis();
        Map<String,Object> map=new HashMap<>(16);
        try {
            List<Area> areaList = areaService.queryArea();
            map.put("rows",areaList);
            map.put("total",areaList.size());
        }catch (ServiceException e){
            e.printStackTrace();
            map.put("success",false);
            map.put("error",e.toString());
        }
        log.error("----testError");
        long endTime=System.currentTimeMillis();
        log.debug("cost:[{}ms]",endTime-startTime);
        log.info("++++++++++end+++++++++++");
        return map;
    }
}
