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

    @Test
    public void getAllListCacheKeyMethodNameTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyMethodName());
        System.out.println(userService.getAllListCacheKeyMethodName());

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach(((k,v)-> System.out.println("key = " + k + " value = " + v)));
    }

    @Test
    public void getAllListCacheKeyMethodTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyMethod());
        System.out.println(userService.getAllListCacheKeyMethod());

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void getAllListCacheKeyTargetTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyTarget());
        System.out.println(userService.getAllListCacheKeyTarget());

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void getAllListCacheKeyTargetClassTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyTargetClass());
        System.out.println(userService.getAllListCacheKeyTargetClass());

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void getAllListCacheKeyArgsTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyArgs("str1", "str2"));
        System.out.println(userService.getAllListCacheKeyArgs("str1", "str2"));
        System.out.println(userService.getAllListCacheKeyArgs("str1", "str3"));
        System.out.println(userService.getAllListCacheKeyArgs("str1", "str3"));

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void getAllListCacheKeyCachesTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheKeyCaches());
        System.out.println(userService.getAllListCacheKeyCaches());

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void getAllListCacheConditionTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheCondition("张三", 15));
        System.out.println(userService.getAllListCacheCondition("张三", 15));

        System.out.println(userService.getAllListCacheCondition("李四",21));
        System.out.println(userService.getAllListCacheCondition("李四",21));

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));

    }

    @Test
    public void getAllListCacheUnlessTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheUnless("张三", 15));
        System.out.println(userService.getAllListCacheUnless("张三", 15));

        System.out.println(userService.getAllListCacheUnless("李四",21));
        System.out.println(userService.getAllListCacheUnless("李四",21));

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v) -> System.out.println("key = " + k + " value = " + v));

    }

    @Test
    public void getAllListCacheSyncTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAllListCacheSync("张三", 15));
        System.out.println(userService.getAllListCacheSync("张三",15));

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v) -> System.out.println("key = " + k + " value = " + v));
    }

    @Test
    public void addUserTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);


        System.out.println(userService.findUserById(10L));
        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));
        System.out.println(userService.addUser("张三", 10L));
        System.out.println(userService.findUserById(10L));
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));

    }

    @Test
    public void deleteByIdTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyCacheConfig.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.findUserById(10L));
        System.out.println(userService.findUserById(20L));

        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache myCache = (ConcurrentMapCache)cacheManager.getCache("myCache");
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));

        userService.deleteById(10L);
        myCache.getNativeCache().forEach((k,v)-> System.out.println("key = " + k + " value = " + v));

    }
}
