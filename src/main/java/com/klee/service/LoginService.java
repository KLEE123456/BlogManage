package com.klee.service;

import com.klee.mapper.LoginMapper;
import com.klee.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public User loginService(String userName,String userPwd){
        return  loginMapper.userLogin(userName,userPwd);
    }
}
