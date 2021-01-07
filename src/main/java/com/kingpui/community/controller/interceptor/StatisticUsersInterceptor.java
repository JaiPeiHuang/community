package com.kingpui.community.controller.interceptor;

import com.kingpui.community.entity.User;
import com.kingpui.community.service.StatisticsUsers;
import com.kingpui.community.util.HostHolder;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StatisticUsersInterceptor implements HandlerInterceptor {

    @Autowired
    private StatisticsUsers statisticsUsers;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 统计UV
        String ip = request.getRemoteHost();
        statisticsUsers.recordUV(ip);

        // 统计DAU
        User user = hostHolder.getUser();
        if (user != null){
            statisticsUsers.recordDAU(user.getId());
        }
        return  true;

    }
}
