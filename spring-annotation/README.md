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
##属性赋值
1、@Value或者xml中的property标签</br>
①、基本数值</br>
②、spl表达式,#{}</br>
③、${}取出配置文件中的值,取出配置文件中的值,在环境变量中的值</br>
2、@PropertySource,加载外部配置文件，取出配置文件中的k v, 保存在运行环境变量中</br>
##自动装配
Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值.</br>

###1、@Autowired
1、默认按照类型去容器中找对应的组件.</br>
2、如果按照类型找到多个相同的组件,再将属性名作为组件的id去容器中查找.</br>
3、可以使用@Qualifier(bean名字)明确指定使用哪个组件</br>
4、如果容器中不存在相关的组件会报错,注册bean不成功,使用@Autowired(required=false)则不会报错,注入的组件为null.</br>
5、@Primary:让spring进行自动装配的时候，默认使用首选的bean,也可以使用@Qualifier明确指定使用哪个bean.</br>
spring注解,可以用在属性、方法、构造器、参数.</br>
它们的区别在于加载顺序的不同</br>
###2、@Resource
JSR250(Java规范)
默认按照名称自动装配,即@Resource(bean名称),没有支持@Primary和required = false的功能.</br>
###3、@Inject
JSR330(Java规范)
需要加入依赖</br>
```
<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    <version>1</version>
</dependency>
```
和@Autowried一样,没有required = false的功能.</bean>
注:AutowiredAnnotationBeanPostProcessor完成上述注解的自动装配.</br>
###4、自定义组件
自定义组件想要使用spring容器底层的一些组件(比如ApplicationContext、BeanFactory、等等),自定义组件实现xxxAware,在创建组件时会调用自定义组件实现的方法,即实现了把spring底层的容器注入到自定义的bean中.</br>
* ApplicationEventPublisherAware
* MessageSourceAware
* ResourceLoaderAware
* ApplicationStartupAware
* NotificationPublisherAware
* BeanFactoryAware
* EnvironmentAware
* ImportAware
* EmbeddedValueResolverAware
* BootstrapContextAware
* LoadTimeWeaverAware
* BeanClassLoaderAware
* ApplicationContextAware
上述的xxxAware都是通过xxxAwareProcessor处理的.</br>
##3、总结

##4、Aop
###步骤:
+ 导入aop模块,spring-aspects
+ 定义业务类(MathCalculator),在业务逻辑运行时将日志打印(方法运行前、方法运行后、方法返回结果、方法出现异常等等)
+ 定义日志切面类(LogAspects),切面类里面的方法需要动态感知MathCalculator中方法运行到哪
    通知方法:
        前置通知(@Before):在目标方法运行前
        后置通知(@After):在目标方法运行后(无论正常结束还是异常结束)
        返回通知(@AfterReturning):在目标方法返回结果后
        异常通知(@AfterThrowing):在目标方法返回异常后
        环绕通知(@Around):动态代理,手动推进目标方法运行(joinPoint.procced())
+ 给切面类的目标方法标注何时何地运行(通知注解)
+ 将目标类和切面类都加入到容器中
+ 通过注解@Aspect告诉spring哪个类时切面类
+ 配置类添加@EnableAspectJAutoProxy，开启基于注解的aop模式
###源码解析
1. 配置类添加@EnableAspectJAutoProxy开启AOP自动注解功能
2. @EnableAspectJAutoProxy会给容器注册一个AnnotationAwareAspectJAutoProxyCreator后置通知组件
3. 容器创建流程
    1. registerBeanPostProcessor()注册后置处理器,创建AnnotationAwareAspectJAutoProxyCreator对象
    2. finishBeanFactoryInitialization()初始化剩下的单实例bean
       1. 创建业务逻辑组件和切面组件
       2. AnnotationAwareAspectJAutoProxyCreator拦截组件的创建过程
       3. 组件创建完之后,判断组件是否需要增强,如果是,则将通知的切面方法包装成切面的增强器(Advisor),然后给业务逻辑组件创建代理对象.
4. 执行目标方法
   1. 代理对象执行目标方法
   2. CglibAopProxy.intercept()进行拦截
      1. 得到目标方法的拦截器链(增强器包装成拦截器MethodInterceptor)
      2. 利用拦截器链机制,依次进入每个拦截器进行执行
      3. 效果
         1. 正常执行:前置通知-->目标方法-->后置通知-->返回通知
         2. 异常执行:前置通知-->目标方法-->后置通知-->异常通知

