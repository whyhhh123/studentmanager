package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.ClassService;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassService classService;

    @GetMapping("/index/tables/teacherlist")
    public String teacherList(Model model){
        List<Teacher> teachers = teacherService.findAllTeacher();
        model.addAttribute("teachers",teachers);
        return "index/tables/teacherlist";
    }

    @GetMapping("/addteacher")
    public String getAddTeacher(){
        return "index/teacher/addteacher";
    }

    @PostMapping("/add_teacher/0")
    public String postAddTeacher(Teacher teacher,Model model){

        int result = teacherService.addTeacher(teacher);
        if(result>0){
            List<Teacher> teachers = teacherService.findAllTeacher();
            model.addAttribute("teachers",teachers);
            return "index/tables/teacherlist";
        }
        else{
            return "index/teacher/addteacher";
        }
    }
    @GetMapping("/updateteacher/{id}")
    public String getUpdateTeacher(@PathVariable("id")Integer id, Model model){
        System.out.println("id = " + id );
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher",teacher);
        return "index/teacher/updateteacher";
    }
    @PostMapping("/updateteacher/{id}")
    public String postUpdateTeacher(@PathVariable("id")Integer id,Teacher teacher,Model model){

        teacher.setId(id);
        System.out.println( " teacher = " + teacher );
        int result = teacherService.updateTeacher(teacher);
        if(result>0){
            List<Teacher> teachers = teacherService.findAllTeacher();
            model.addAttribute("teachers",teachers);
            return "index/tables/teacherlist";
        }
        else{
            return "index/teacher/updateteacher";
        }

    }

    @GetMapping("/deleteteacher/{id}")
    public String deleteTeacher(@PathVariable("id")Integer id,Model model){
        int result = teacherService.deleteTeacher(id);
        if(result>0){
            List<Teacher> teachers = teacherService.findAllTeacher();
            model.addAttribute("teachers",teachers);
        }
        else{

        }

        return "index/tables/teacherlist";
    }


}
