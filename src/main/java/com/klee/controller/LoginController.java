package com.klee.controller;

import com.klee.pojo.User;
import com.klee.service.LoginService;
import com.klee.utils.Md5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/userLogin")
    public String loginCheck(Model model, @RequestParam(value = "username") String userName, @RequestParam(value = "password") String userPwd, HttpSession session){
        System.out.println(userName+","+userPwd);
        userPwd=Md5Encrypt.MD5(userPwd);
        User user=loginService.loginService(userName,userPwd);
        if (user==null){
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }
        session.setAttribute("loginUser",user);
        return "redirect:index.html";
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping("/userExit")
    public String destorySession(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:login.html";
    }
}
