package com.klee.mapper;

import com.klee.pojo.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper {
    List<Blog> getBlog(Map<String,String> blogMap);
}
