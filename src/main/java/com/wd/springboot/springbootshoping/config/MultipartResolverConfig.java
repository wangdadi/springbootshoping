package com.wd.springboot.springbootshoping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * ClassName:MultipartResolver
 * Package:com.wd.springboot.springbootshoping.config
 * Description:
 * 文件上传解析器
 * @Date:2019/6/2 0002 19:32
 * @Author:王迪
 */
@Configuration
public class MultipartResolverConfig {
    @Bean
    public CommonsMultipartResolver newCommonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        //最大文件大小
        multipartResolver.setMaxUploadSize(20971520);
        //最大内存
        multipartResolver.setMaxInMemorySize(20971520);
        return multipartResolver;
    }
}
