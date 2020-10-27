package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/index/tables/classlist")
    public String classList(Model model){
        List<Clazz> clazzes = classService.findAllClass();
        System.out.println("班级"+clazzes);
        model.addAttribute("clazzes",clazzes);
        return "/index/tables/classlist";
    }

    @GetMapping("/addclass")
    public String addclass(Clazz clazz,Model model){


        return null;
    }

}
