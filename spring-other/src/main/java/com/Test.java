package com;

import com.service.EmployeeService;
import com.service.UserService;
import com.service1.EmployeeService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.service1")
public class Test {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        UserService bean = context.getBean(UserService.class);
//        System.out.println(bean.getUserMaps());

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.refresh();
//        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
//        int scan = scanner.scan("com.service");
//
//
//        EmployeeService bean = context.getBean(EmployeeService.class);
//
//        System.out.println(bean);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        EmployeeService1 bean = context.getBean(EmployeeService1.class);
        System.out.println(bean);
    }
}
