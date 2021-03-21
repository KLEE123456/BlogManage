package com.klee.service;

import com.klee.mapper.BlogTagMapper;
import com.klee.pojo.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTagService {
    @Autowired
    private BlogTagMapper blogTagMapper;

    public List<BlogTag> getAllBlogTag(){
        return blogTagMapper.getAllBlogTag();
    }

    public  BlogTag getBlogTagByName(String blogTagName){
        return blogTagMapper.getBlogTagByName(blogTagName);
    }

    public int addBlogTag(BlogTag blogTag){
        return blogTagMapper.addBlogTag(blogTag);
    }

    public  int deleteBlogTag(int blogTagId){
        return blogTagMapper.deleteBlogTag(blogTagId);
    }

    public BlogTag findBlogTagById(int blogTagId){
        return blogTagMapper.findBlogTagById(blogTagId);
    }

    public  int updateBlogTag(BlogTag blogTag){
        return blogTagMapper.updateBlogTag(blogTag);
    }
}
