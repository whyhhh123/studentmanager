package com.why.studentmanager.interceptor;

import com.why.studentmanager.domain.Admin;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin=(Admin) request.getSession().getAttribute("admin");

        if(!StringUtils.isEmpty(admin)){
            return true;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/login");

            return false;
        }

    }
}
