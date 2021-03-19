package com.klee.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
public class User implements Serializable {
    private int userId;
    private String userNickName;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userType;
    private Date uCreateTime;
    private Date uUpdateTime;

}
