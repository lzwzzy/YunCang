package com.yuncang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lzw on 2017/5/26.
 * 全局拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    String user=null;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        user = (String)httpServletRequest.getSession().getAttribute("user");
        if (user == null){
            httpServletResponse.sendRedirect("/yuncang/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("user",user);
        System.out.println("MyInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
