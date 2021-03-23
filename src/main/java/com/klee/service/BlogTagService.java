package com.klee.service;

import com.github.pagehelper.PageHelper;
import com.klee.mapper.BlogTagMapper;
import com.klee.pojo.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTagService {
    @Autowired
    private BlogTagMapper blogTagMapper;

    public List<BlogTag> getAllBlogTag(int pageNum){
        PageHelper.startPage(pageNum,5);
        List<BlogTag> blogTagList=blogTagMapper.getAllBlogTag();
        return blogTagList;
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
