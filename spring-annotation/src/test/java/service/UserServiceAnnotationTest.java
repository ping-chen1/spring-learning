package service;

import com.config.SpringConfig;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceAnnotationTest {

    /**
     * 通过 config + bean 注解的方式 注册bean
     */
    @Test
    public void findAllUser(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.findAllUser();
    }

    /**
     * 使用ComponentScan 注解扫描包自动注册 类似spring中的 <context:component-scan></context:component-scan> 标签
     * excludeFilters 排除某些符合条件的类不被扫描，FilterType.ANNOTATION 根据注解类型排除，classes 排除的注解是什么
     * @ComponentScan(basePackages = "com"
     * excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
     *
     * useDefaultFilters 默认为true 代表使用默认的过滤器，所有的都扫描，设置为false 自己设置的include 才生效
     * includeFilters 包含哪些条件 FilterType.ANNOTATION注解类型的，Controller注解的类
     * @ComponentScan(value = "com",useDefaultFilters = false,
     * includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
     */
    @Test
    public void findAllBeansByComponentScan(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }


}
