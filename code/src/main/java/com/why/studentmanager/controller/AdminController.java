
package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @GetMapping("/SEE")
    public Admin see(){
        Admin admin = new Admin();
        admin.setPassword("adfaf");
        admin.setId(15);
        admin.setUsername("fadfa");
        return admin;
    }

}


