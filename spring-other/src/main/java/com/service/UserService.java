package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeService employeeService;

    private List<Map<String,Object>> userMaps;

    public UserService(){
        System.out.println("userService");
    }

    @PostConstruct
    private void init(){
        System.out.println("init");
        userMaps  = jdbcTemplate.queryForList("select * from t_user");
    }

    public List<Map<String, Object>> getUserMaps() {
        return userMaps;
    }

    public void setUserMaps(List<Map<String, Object>> userMaps) {
        this.userMaps = userMaps;
    }
}
