package com.springxuexi.springboot04.shitilei;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class lanjieqi implements HandlerInterceptor {
    @Override
    //目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user= request    .getSession().getAttribute("indexname");
        if (user == null){
            //没登陆。应该拦截 并返回登录界面
            request.setAttribute("msg","没有权限请登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
             return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
