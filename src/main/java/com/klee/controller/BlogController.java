package com.klee.controller;

import com.github.pagehelper.PageInfo;
import com.klee.mapper.BlogMapper;
import com.klee.mapper.BlogTagMapper;
import com.klee.mapper.BlogTypeMapper;
import com.klee.pojo.Blog;
import com.klee.pojo.BlogTag;
import com.klee.pojo.BlogType;
import com.klee.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private BlogTagMapper blogTagMapper;

    /**
     * BLog列表查询
     * @param model
     * @param blType
     * @param blTitle
     * @param pageNum
     * @return
     */
    @RequestMapping("/findBlog")
    public String getBlog(Model model, String blType, String blTitle,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        Map<String,String> blogMap=new HashMap();
        blogMap.put("blType",blType);
        blogMap.put("blTitle",blTitle);
        List<Blog> blogList=blogService.getBlog(blogMap,pageNum);
        List<BlogType> blogTypeList=blogTypeMapper.getBlogType();
        PageInfo pageInfo=new PageInfo(blogList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("blogList",blogList);
        model.addAttribute("blogTypeList",blogTypeList);
        model.addAttribute("HtBTitle",blTitle);
        model.addAttribute("HtBType",blType);
        return "blogList";
    }

    /**
     * 回填blog新增页面博客类别和标签
     * @param model
     * @return
     */
    @RequestMapping("/getSelectMsg")
    public  String getSelectMsg(Model model){
        List<BlogType> blogTypeList = blogTypeMapper.getBlogType();
        List<BlogTag> blogTagList=blogTagMapper.getAllBlogTag();
        model.addAttribute("blogTypeList",blogTypeList);
        model.addAttribute("blogTagList",blogTagList);
        return "blogAdd";
    }
}
