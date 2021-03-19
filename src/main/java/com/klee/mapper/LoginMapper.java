package com.klee.mapper;

import com.klee.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    User userLogin(@Param("userName") String userName, @Param("userPwd") String userPwd);
}
