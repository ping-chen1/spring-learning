package service;

import com.alibaba.fastjson.JSON;
import com.aop.MathCalculatorAop;
import com.service.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MathCalculatorTest {

    @Test
    public void divTest(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MathCalculatorAop.class);
        MathCalculator bean = context.getBean(MathCalculator.class);
        System.out.println(JSON.toJSONString(bean));
        int div = bean.div(10, 2);
        System.out.println(div);
        System.out.println("##################################");
        int div1 = bean.div(10, 0);
        System.out.println(div1);
    }
}
