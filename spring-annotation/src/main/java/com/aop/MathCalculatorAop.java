package com.aop;

import com.service.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MathCalculatorAop {

    /**
     * 业务逻辑类注册到容器中
     * @return
     */
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    /**
     * 切面类注册到容器中
     * @return
     */
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
