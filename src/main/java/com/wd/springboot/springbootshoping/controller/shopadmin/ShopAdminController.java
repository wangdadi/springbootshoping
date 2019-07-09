package com.wd.springboot.springbootshoping.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:IndexController
 * Package:com.wd.springboot.springbootshoping.controller
 * Description:
 *
 * @Date:2019/5/16 0016 14:29
 * @Author:王迪
 */
@Controller
public class ShopAdminController {
    @RequestMapping("/shopAdmin")
    public String index(){

        return "index";
    }
}
