package com.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class CatLifeBean implements InitializingBean, DisposableBean {

    private String name;

    public CatLifeBean(){
        System.out.println("CatLifeBean 创建...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("CatLifeBean setName...");
        this.name = name;
    }

    public void init(){
        System.out.println("CatLifeBean @Bean init...");
    }

    @PostConstruct
    public void init_A(){
        System.out.println("CatLifeBean @PostConstruct...");
    }

    public void destroy_A(){
        System.out.println("CatLifeBean @Bean destroy...");
    }

    @PreDestroy
    public void destroy_B(){
        System.out.println("CatLifeBean @PreDestroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CatLifeBean InitializingBean afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("CatLifeBean DisposableBean destroy...");
    }
}
