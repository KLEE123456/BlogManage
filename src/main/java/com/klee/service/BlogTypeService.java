package com.klee.service;

import com.klee.mapper.BlogTypeMapper;
import com.klee.pojo.BlogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogTypeService {
    @Autowired
    private BlogTypeMapper blogTypeMapper;
    public List<BlogType> getBlogType(){
        return  blogTypeMapper.getBlogType();
    }
    public  BlogType checkBlogType(String blType){
        return blogTypeMapper.checkBlogType(blType);
    }
    public  int addBlogType(BlogType blogType){
        return blogTypeMapper.addBlogType(blogType);
    }
    public  int deleteBlogType(int blogTypeId){
        return blogTypeMapper.deleteBlogType(blogTypeId);
    }
    public  BlogType findBTypeById(int blogTypeId){
        return blogTypeMapper.findBTypeById(blogTypeId);
    }
    public  int updateBType(int bTypeId,String bTypeName){
        return blogTypeMapper.updateBlogType(bTypeId,bTypeName);
    }
}
