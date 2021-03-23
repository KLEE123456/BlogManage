package com.klee.controller;

import com.klee.mapper.BlogMapper;
import com.klee.mapper.BlogTypeMapper;
import com.klee.pojo.Blog;
import com.klee.pojo.BlogType;
import com.klee.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeMapper blogTypeMapper;


    @RequestMapping("/findBlog")
    public String getBlog(Model model, String blType, String blTitle){
        Map<String,String> blogMap=new HashMap();
        blogMap.put("blType",blType);
        blogMap.put("blTitle",blTitle);
        List<Blog> blogList=blogService.getBlog(blogMap);
        System.out.println(blogList);
        List<BlogType> blogTypeList=blogTypeMapper.getBlogType();
        model.addAttribute("blogList",blogList);
        model.addAttribute("blogTypeList",blogTypeList);
        model.addAttribute("HtBTitle",blTitle);
        model.addAttribute("HtBType",blType);
        return "blogList";
    }


}
