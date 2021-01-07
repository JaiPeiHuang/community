package com.kingpui.community.controller.interceptor;

import com.kingpui.community.annotation.LoginRequired;
import com.kingpui.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author KingPuiWong
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;


    /**
     *  在用户访问的时候，判断访问的方法是否有注解，
     *  有的话再判断用户是否登录，如果没登录，就跳转到登录页面；
     *  如果用户登录了，就允许访问。
     * @param request
     * @param response
     * @param handler
     * @return
     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod){
//            HandlerMethod handlerMethod =(HandlerMethod)handler;
//            Method method=handlerMethod.getMethod();
//            LoginRequired loginRequired =method.getAnnotation(LoginRequired.class);
//            if (loginRequired !=null && hostHolder.getUser()==null){
//                response.sendRedirect(request.getContextPath()+"/login");
//                return false;
//            }
//
//        }
//
//        return true;
//    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequiredAnnotation = method.getAnnotation(LoginRequired.class);
            if (loginRequiredAnnotation!=null && hostHolder.getUser()==null){
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        }
        return true;
    }

}

