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

}
