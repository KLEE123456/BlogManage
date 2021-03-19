package com.klee.controller;

import com.klee.pojo.BlogType;
import com.klee.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 博客类型控制器类
 */
@Controller
public class BlogTypeController {
    @Autowired
    private BlogTypeService blogTypeService;

    /**
     * 获取所有博客类型
     * @param model
     * @return
     */
    @RequestMapping("/getBlogType")
    public String getBType(Model model){
        List<BlogType> blogTypeList=blogTypeService.getBlogType();
        model.addAttribute("blogTypeList",blogTypeList);
        return "blogTypeList";
    }

    /**
     * 检测用户添加的博客类别是否重复
     * @param blogType
     * @param response
     * @throws IOException
     */
    @RequestMapping("/checkBType")
    public  void chkBType(String blogType, HttpServletResponse response) throws IOException {
        BlogType blogType1=blogTypeService.checkBlogType(blogType);
        PrintWriter out=response.getWriter();
        if (blogType1==null){
            out.print(1);
        }
        else {
            out.print(0);
        }
    }

    @RequestMapping("/addBlogType")
    public void addBType(BlogType blogType,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.addBlogType(blogType);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);
        }
        else {
            out.print(0);
        }
    }

    @RequestMapping("/delBlogType")
    public void  deleteBType(int bTypeId,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.deleteBlogType(bTypeId);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);
        }
        else {
            out.print(0);
        }
    }

    @RequestMapping("/findBlogTypeById")
    public String findBTypeById(int bTypeId,Model model){
        BlogType blogType=blogTypeService.findBTypeById(bTypeId);
        model.addAttribute("blogType",blogType);
        return "blogTypeUpdate";
    }

    @RequestMapping("/updateBlogType")
    public void  updateBType(int bTypeId,String bTypeName,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.updateBType(bTypeId,bTypeName);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);
        }
        else {
            out.print(0);
        }
    }
}
