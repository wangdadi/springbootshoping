package com.wd.springboot.springbootshoping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * ClassName:com.wd.springboot.springbootshoping
 * Package:PACKAGE_NAME
 * Description:
 * 主启动类
 * @Date:2019/4/26 0026 23:30
 * @Author:王迪
 */
@MapperScan("com.wd.springboot.springbootshoping.dao")
@SpringBootApplication
public class SpringbootshopingApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootshopingApplication.class, args);
    }

}
