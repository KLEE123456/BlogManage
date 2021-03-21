package com.klee.controller;

import com.klee.pojo.BlogTag;
import com.klee.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class BlogTagController {
    @Autowired
    private BlogTagService blogTagService;

    /**
     * 获取所有博客标签
     * @param model
     * @return
     */
    @RequestMapping("/getBlogTag")
    public String getAllBlogTag(Model model){
        List<BlogTag> blogTagList=blogTagService.getAllBlogTag();
        model.addAttribute("blogTagList",blogTagList);
        return "blogTagList";
    }

    /**
     * 检查博客标签是否重复
     * @param blogTagName
     * @param response
     * @throws IOException
     */
    @RequestMapping("/checkBlTag")
    public  void checkBlogTag(String blogTagName, HttpServletResponse response) throws IOException {
        BlogTag blogTag=blogTagService.getBlogTagByName(blogTagName);
        PrintWriter out=response.getWriter();
        if (blogTag==null){
            out.print(1);//非重复返回1
        }
        else {
            out.print(0);//重复返回0
        }
    }

    /**
     * 添加博客标签
     * @param blogTag
     * @param response
     * @throws IOException
     */
    @RequestMapping("/addBlTag")
    public void addBlogTag(BlogTag blogTag,HttpServletResponse response) throws IOException{
        int rows=blogTagService.addBlogTag(blogTag);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//添加成功返回1
        }
        else {
            out.print(0);//添加失败返回0
        }
    }

    /**
     * 删除博客标签
     * @param response
     * @param blogTagId
     * @throws IOException
     */
    @RequestMapping("/delBlogTag")
    public void deleteBlogTag(HttpServletResponse response,int blogTagId) throws IOException{
        int rows=blogTagService.deleteBlogTag(blogTagId);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//删除成功返回1
        }
        else {
            out.print(0);//删除失败返回0
        }
    }

    /**
     * 编辑回填
     * @param model
     * @param bTagId
     * @return
     */
    @RequestMapping("/findBlTagById")
    public String findBlogTagById(Model model,int bTagId){
        BlogTag blogTag=blogTagService.findBlogTagById(bTagId);
        model.addAttribute("blogTag",blogTag);
        return "blogTagUpdate";
    }

    /**
     * 编辑博客
     * @param blogTag
     * @param response
     * @throws IOException
     */
    @RequestMapping("/updateBlTag")
    public void updateBlogTag(BlogTag blogTag,HttpServletResponse response) throws IOException{
        int rows=blogTagService.updateBlogTag(blogTag);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//编辑成功返回1
        }
        else {
            out.print(0);//编辑失败返回0
        }
    }
}
