package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration //告诉spring 这是一个配置类 相当于一个spring.xml
//@ComponentScan(basePackages = "com",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
@ComponentScan(value = "com",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
public class SpringConfig {

//    @Bean//相当于一个bean标签，bean的名称 方法名，可以通过bean注解的 value指定名称
//    public UserService userService(){
//        return new UserServiceImpl();
//    }
}
