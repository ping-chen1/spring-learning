# spring-annotation

## 1、组件注册


## 2、bean的声明周期

### 1、创建
单实例:在容器启动的时候创建对象</br>
多实例:在每次获取的时候创建对象</br>
### 初始化之前
实现org.springframework.beans.factory.config.BeanPostProcessor.postProcessBeforeInitialization

### 2、初始化
对象创建完成,并且赋值完成,调用初始化方法,指定初始化方法有如下几种方式</br>
1、使用@Bean注解中的initMethod方法,等同于xml中bean标签的init-method属性</br>
2、通过bean实现InitializingBean接口</br>
3、使用JSR250(java规范)@PostConstruct注解,bean创建完成并且完成属性赋值,来执行初始化方法</br>
###初始化之后
实现org.springframework.beans.factory.config.BeanPostProcessor.postProcessAfterInitialization

### 3、销毁
1、使用@Bean注解中的destroyMethod方法,等同于xml中bean标签的destroy-method属性</br>
2、通过bean实现DisposableBean接口</br>
3、使用JSR250(java规范)@PreDestroy注解,在容器移除bean之前.</br>
注意:
单实例:容器关闭的会执行</br>
多实例：容器关闭不会调用销毁方法</br>

### 总结
CatLifeBean测试结果
```
信息: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@2eafffde: startup date [Sun Aug 14 17:58:21 CST 2022]; root of context hierarchy
BeanPostProcessor beanName org.springframework.context.event.internalEventListenerProcessorbean-->postProcessBeforeInitialization ...
BeanPostProcessor beanName org.springframework.context.event.internalEventListenerProcessorbean-->postProcessAfterInitialization ...
BeanPostProcessor beanName org.springframework.context.event.internalEventListenerFactorybean-->postProcessBeforeInitialization ...
BeanPostProcessor beanName org.springframework.context.event.internalEventListenerFactorybean-->postProcessAfterInitialization ...
BeanPostProcessor beanName catLifeConfigbean-->postProcessBeforeInitialization ...
BeanPostProcessor beanName catLifeConfigbean-->postProcessAfterInitialization ...
CatLifeBean 创建...
CatLifeBean setName...
BeanPostProcessor beanName catLifeBeanbean-->postProcessBeforeInitialization ...
CatLifeBean @PostConstruct...
CatLifeBean InitializingBean afterPropertiesSet...
CatLifeBean @Bean init...
BeanPostProcessor beanName catLifeBeanbean-->postProcessAfterInitialization ...
八月 14, 2022 5:58:21 下午 org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
信息: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@2eafffde: startup date [Sun Aug 14 17:58:21 CST 2022]; root of context hierarchy
CatLifeBean @PreDestroy...
CatLifeBean DisposableBean destroy...
CatLifeBean @Bean destroy...

Process finished with exit code 0

```
###Spring底层对BeanPostProcessor的使用
1、注解@Async,通过org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor处理异步方法</br>
2、org.springframework.validation.beanvalidation.MethodValidationPostProcessor</br>
3、注入IOC容器,bean实现ApplicationContextAware、EnvironmentAware、EmbeddedValueResolverAware、ResourceLoaderAware、ApplicationEventPublisherAware、MessageSourceAware接口,通过org.springframework.context.support.ApplicationContextAwareProcessor实现</br>
4、数据校验,通过org.springframework.validation.beanvalidation.BeanValidationPostProcessor实现</br>
5、处理@PostConstruct和@PreDestroy注解,通过org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor实现</br>
6、注解@Autowired,通过org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor实现</br>
7、注入其他组件,等等.