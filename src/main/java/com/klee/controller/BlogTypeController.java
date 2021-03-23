package com.klee.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.klee.pojo.BlogType;
import com.klee.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public String getBType(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        System.out.println(pageNum);
        List<BlogType> blogTypeList=blogTypeService.getBlogType(pageNum);
        PageInfo pageInfo=new PageInfo(blogTypeList);
        model.addAttribute("blogTypeList",blogTypeList);
        model.addAttribute("pageInfo",pageInfo);
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
            out.print(1);//非重复返回1
        }
        else {
            out.print(0);//重复返回0
        }
    }

    /**
     * 添加博客类别
     * @param blogType
     * @param response
     * @throws IOException
     */
    @RequestMapping("/addBlogType")
    public void addBType(BlogType blogType,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.addBlogType(blogType);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//添加成功返回1
        }
        else {
            out.print(0);//修改失败返回0
        }
    }

    /**
     * 删除博客类别
     * @param bTypeId
     * @param response
     * @throws IOException
     */
    @RequestMapping("/delBlogType")
    public void  deleteBType(int bTypeId,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.deleteBlogType(bTypeId);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//删除成功返回1
        }
        else {
            out.print(0);//修改失败返回0
        }
    }

    /**
     * 编辑回填
     * @param bTypeId
     * @param model
     * @return
     */
    @RequestMapping("/findBlogTypeById")
    public String findBTypeById(int bTypeId,Model model){
        BlogType blogType=blogTypeService.findBTypeById(bTypeId);
        model.addAttribute("blogType",blogType);
        return "blogTypeUpdate";
    }

    /**
     * 编辑博客类别
     * @param bTypeId
     * @param bTypeName
     * @param response
     * @throws IOException
     */
    @RequestMapping("/updateBlogType")
    public void  updateBType(int bTypeId,String bTypeName,HttpServletResponse response) throws IOException {
        int rows=blogTypeService.updateBType(bTypeId,bTypeName);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print(1);//修改成功返回1
        }
        else {
            out.print(0);//修改失败返回0
        }
    }
}
