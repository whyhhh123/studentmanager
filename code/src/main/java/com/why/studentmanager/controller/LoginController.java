package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.AdminService;
import com.why.studentmanager.service.StudentService;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/index")
    public String login(String username, String password, String type, Model model, HttpSession session){
        if(StringUtils.isEmpty(username)){
            model.addAttribute("usermsg","请输入账号");
            return "login";
        }
        else if(StringUtils.isEmpty(password)){
            model.addAttribute("pwdmsg","请输入密码");
            return "login";
        }
        else if(StringUtils.isEmpty(type)){
            model.addAttribute("typemsg","请选择职位");
            return "login";
        }

        if(type.equals("1")){
            Student student = new Student();
            student.setUsername(username);
            student.setPassword(password);
            Student st =studentService.findByStudent(student);
            if(org.springframework.util.StringUtils.isEmpty(st)){
                model.addAttribute("system","用户密码错误");

                return "/login";
            }
            session.setAttribute("student",st);
            return "/index/index";
        }
        else if(type.equals("2")){
            Teacher teacher = new Teacher();
            teacher.setUsername(username);
            teacher.setPassword(password);
        }
        else if(type.equals("3")){
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            Admin ad = adminService.findByAdmin(admin);
            if(org.springframework.util.StringUtils.isEmpty(ad)){
                model.addAttribute("system","用户密码错误");

                return "/login";
            }
            session.setAttribute("admin",ad);
            return"/index/index";

        }
        return "/login";
    }




}
