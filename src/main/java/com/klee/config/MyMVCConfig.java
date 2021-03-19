package com.klee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/welcome.html").setViewName("welcome");
        registry.addViewController("/blogTypeList.html").setViewName("blogTypeList");
        registry.addViewController("/error.html").setViewName("error");
        registry.addViewController("/blogTypeAdd.html").setViewName("blogTypeAdd");
        registry.addViewController("/blogTypeUpdate.html").setViewName("blogTypeUpdate");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login.html","/css/**","/fonts/**","/images/**","/js/**","/lib/**","/userLogin");
    }
}
