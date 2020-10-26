package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.service.AdminService;
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

        }
        else if(type.equals("2")){

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
        return "/index/index";
    }

    /*@GetMapping("/index/tables/datatables.html")
    public String ii(){
        return "index/tables/datatables";
    }*/


}
