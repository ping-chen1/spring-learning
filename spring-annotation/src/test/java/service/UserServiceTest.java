package service;

import com.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    /**
     * 通过spring.xml 配置bean标签的形式注册bean
     */
    @Test
    public void findAllUserTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService bean = context.getBean(UserService.class);
        bean.findAllUser();
    }

    @Test
    public void findAllBeansByComponentScanTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
            System.out.println(bean);
        }
    }
}
