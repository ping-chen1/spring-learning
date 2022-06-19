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

    @Cacheable(cacheNames = "myCache",key = "#root.args[0] + '-' + #root.args[1]")
    public List<String> getAllListCacheKeyArgs(String str1,String str2){
        System.out.println("获取数据");
        return Arrays.asList("F1","F2","F3");
    }

    @Cacheable(cacheNames = "myCache",key = "#root.caches[0].name")
    public List<String> getAllListCacheKeyCaches(){
        System.out.println("获取数据");
        return Arrays.asList("G1","G2","G3");
    }

    @Cacheable(cacheNames = "myCache",key = "#name + '-' + #age",condition = "#age>=20")
    public String getAllListCacheCondition(String name,Integer age){
        System.out.println("获取数据");
        return String.format("name = %s,age = %d",name,age);
    }
}
