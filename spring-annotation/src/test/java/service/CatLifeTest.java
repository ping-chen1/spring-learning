package service;

import com.config.CatLifeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CatLifeTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CatLifeConfig.class);
        context.close();
    }
}
