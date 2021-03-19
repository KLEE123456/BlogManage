package com.klee.config;

import com.klee.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("loginUser");
        if (user==null){
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        return true;
    }
}
