package com.klee.mapper;

import com.klee.pojo.BlogType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogTypeMapper {
    List<BlogType> getBlogType();
    BlogType checkBlogType(String blType);
    int addBlogType(BlogType blogType);
    int deleteBlogType(int blogTypeId);
    BlogType findBTypeById(int blogTypeId);
    int updateBlogType(@Param(value = "id") int blogTypeId, @Param("name") String blogTypeName);
}
