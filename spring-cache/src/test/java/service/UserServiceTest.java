package service;

import config.MyCacheConfig;
import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Collection;

public class UserServiceTest {


    @Test
    public void getAllListTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService bean = context.getBean(UserService.class);
        System.out.println(bean.getAllList());
        System.out.println(bean.getAllList());
        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }
}
