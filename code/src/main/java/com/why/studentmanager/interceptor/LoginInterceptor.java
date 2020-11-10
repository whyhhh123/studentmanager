package com.why.studentmanager.interceptor;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.domain.Teacher;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        if(!StringUtils.isEmpty(admin)||!StringUtils.isEmpty(student)||!StringUtils.isEmpty(teacher)){
            return true;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/login");

            return false;
        }

    }
}
