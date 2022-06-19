package service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Cacheable(cacheNames = "myCache")
    public List<String> getAllList(){
        System.out.println("获取所有数据");
        return Arrays.asList("A1","A2","A3");
    }

    @Cacheable(cacheNames = "myCache",key = "#root.methodName")
    public List<String> getAllListCacheKeyMethodName(){
        System.out.println("获取数据");
        return Arrays.asList("B1","B2","B3");
    }

    @Cacheable(cacheNames = "myCache",key = "#root.method")
    public List<String> getAllListCacheKeyMethod(){
        System.out.println("获取数据");
        return Arrays.asList("C1","C2","C3");
    }

    @Cacheable(cacheNames = "myCache",key = "#root.target")
    public List<String> getAllListCacheKeyTarget(){
        System.out.println("获取数据");
        return Arrays.asList("D1","D2","D3");
    }

    @Cacheable(cacheNames = "myCache",key = "#root.targetClass")
    public List<String> getAllListCacheKeyTargetClass(){
        System.out.println("获取数据");
        return Arrays.asList("E1","E2","E3");
    }
}
