package com.yuncang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lzw on 2017/5/26.
 * 全局拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    private String userSession = null;
    private String userCookie = null;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                userCookie = c.getValue();
                if (userCookie != null) {
                    return true;
                }
            }
        }
        userSession = (String) request.getSession().getAttribute("user");
        if (userSession == null) {
            response.sendRedirect("/yuncang/login");
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        if (userSession != null) {
            modelAndView.addObject("user", userSession);
        } else {
            modelAndView.addObject("user", userCookie);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
