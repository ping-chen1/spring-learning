package com.service;

import com.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Override
    public List<User> findAllUser() {
        System.out.println("userService findAllUser");
        return null;
    }
}
