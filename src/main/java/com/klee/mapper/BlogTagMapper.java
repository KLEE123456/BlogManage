package com.klee.mapper;

import com.klee.pojo.BlogTag;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogTagMapper {
    List<BlogTag> getAllBlogTag();
    BlogTag getBlogTagByName(String bTagName);
    int addBlogTag(BlogTag blogTag);
    int deleteBlogTag(int blogTagId);
    BlogTag findBlogTagById(int bTagId);
    int updateBlogTag(BlogTag blogTag);
}
