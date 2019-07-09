package com.wd.springboot.springbootshoping.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * ClassName:Kaptcha
 * Package:com.wd.springboot.springbootshoping.config
 * Description:
 * 验证码配置
 * @Date:2019/6/2 0002 1:01
 * @Author:王迪
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha newDefaultKaptcha(){
        DefaultKaptcha kaptcha=new DefaultKaptcha();
        /**
         * 定义验证码边框等
         */
        Properties properties=new Properties();
        properties.setProperty("kaptcha.border","no");
        properties.setProperty("kaptcha.textproducer.font.color","black");
        properties.setProperty("kaptcha.image.width","135");
        properties.setProperty("kaptcha.textproducer.char.string","abcde2345678gfynmnpwx");
        properties.setProperty("kaptcha.image.height","50");
        properties.setProperty("kaptcha.noise.color","black");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        properties.setProperty("kaptcha.textproducer.font.names","Arial");
        Config config=new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
