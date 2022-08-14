package com.config;

import com.model.CatLifeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.model")
public class CatLifeConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy_A")
    public CatLifeBean catLifeBean(){
        CatLifeBean catLifeBean = new CatLifeBean();
        catLifeBean.setName("张三");
        return catLifeBean;
    }
}
