
package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.AdminService;
import com.why.studentmanager.service.StudentService;
import com.why.studentmanager.service.TeacherService;
import com.why.studentmanager.until.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/adminupdatepwd")
    public String adminupdatepwd(Model model,HttpServletRequest request){
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        model.addAttribute("admin",admin);
        model.addAttribute("student",student);
        model.addAttribute("teacher",teacher);
        return "/index/adminnewpwd";
    }

    @GetMapping("/studentupdatepwd")
    public String studentupdatepwd(Model model,HttpServletRequest request){
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        model.addAttribute("admin",admin);
        model.addAttribute("student",student);
        model.addAttribute("teacher",teacher);
        return "/index/studentnewpwd";
    }

    @GetMapping("/teacherupdatepwd")
    public String teacherupdatepwd(Model model,HttpServletRequest request){
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        model.addAttribute("admin",admin);
        model.addAttribute("student",student);
        model.addAttribute("teacher",teacher);
        return "/index/teachernewpwd";
    }


    @PostMapping("/updatepwd")
    public String updatepwd(String pwd,String Cpwd, Model model, HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        Student student = (Student) request.getSession().getAttribute("student");
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        if(pwd.equals(Cpwd)){
            int result = 0;
            if(!StringUtils.isEmpty(admin)){
                admin.setPassword(Md5Util.stringToMD5(pwd));
                result = adminService.updatePwdByAdmin(admin);
            }
            if(!StringUtils.isEmpty(teacher)){
                teacher.setPassword(Md5Util.stringToMD5(pwd));
                result = teacherService.updatePwdByTeacher(teacher);
            }
            if(!StringUtils.isEmpty(student)){
                student.setPassword(Md5Util.stringToMD5(pwd));
                result = studentService.updatePwdByStudent(student);
            }
            if(result>0){
                return "/index/index";
            }
            else{
                return "adminnewpwd";
            }
        }
        else{
            model.addAttribute("msg","两次密码不相同，请重新输入");
            if(!StringUtils.isEmpty(admin)){
                return "/index/adminnewpwd";
            }
            if(!StringUtils.isEmpty(teacher)){
                return "/index/teachernewpwd";
            }
            else{
                return "/index/studentnewpwd";
            }
        }

    }

}


