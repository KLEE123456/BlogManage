package com.klee.service;

import com.klee.mapper.BlogMapper;
import com.klee.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getBlog(Map<String,String> blogMap){
        System.out.println(blogMap);
        List<Blog> blogList=blogMapper.getBlog(blogMap);
        return blogList;
    }
}
