package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.ClassService;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/index/tables/classlist")
    public String classList(Model model){
        List<Clazz> clazzes = classService.findAllClass();
        model.addAttribute("clazzes",clazzes);
        return "index/tables/classlist";
    }

    @GetMapping("/addclass")
    public String addClass(Model model){
        List<Teacher> teachers =teacherService.addTeacherClassid();
        model.addAttribute("teachers",teachers);
        return "index/class/addclass";
    }


    @PostMapping("/add_class")
    @Transactional(rollbackFor = {Exception.class})
    public String add_class(Clazz clazz,Model model){
        int result_class = classService.addClass(clazz);
        int result_teacher = teacherService.setClass_id(clazz.getTid());
        if(result_class>0&&result_teacher>0){
            List<Clazz> clazzes = classService.findAllClass();
            model.addAttribute("clazzes",clazzes);
            return "index/tables/classlist";
        }
        else{
            return "index/class/addclass";
        }
    }


    @GetMapping("/updateclass/{class_id}")
    public String updateClass(@PathVariable("class_id") Integer class_id, Model model){
        Clazz clazz =classService.findById(class_id);

        model.addAttribute("clazz",clazz);
        List<Teacher> teachers =teacherService.addTeacherClassid();

        model.addAttribute("teachers",teachers);
        return "index/class/updateclass";

    }

    @PostMapping("/update_class/{class_id}")
    public String updateClass(@PathVariable("class_id")Integer class_id,Clazz clazz,Model model){
        clazz.setClass_id(class_id);
        int result = classService.updateClass(clazz);
        int resultResetTeacher = teacherService.resetClass_id(teacherService.findByClassid(class_id).getTid());
        int resultSetTeacher = teacherService.setClass_id(clazz.getTid());
        if(result>0&&resultSetTeacher>0&&resultResetTeacher>0){

            List<Clazz> clazzes = classService.findAllClass();

            model.addAttribute("clazzes",clazzes);
            return "index/tables/classlist";
        }
        else{
            return "index/class/updateclass";
        }
    }


    @GetMapping("/deleteclass/{class_id}")
    public String deleteClass(@PathVariable("class_id")Integer class_id,Model model){



        int deleteResult = classService.deleteClass(class_id);
        if(deleteResult>0){
            teacherService.resetClass_id(teacherService.findByClassid(class_id).getTid());
            List<Clazz> clazzes = classService.findAllClass();
            model.addAttribute("clazzes",clazzes);

        }
        else{
            model.addAttribute("nodeleteclass","删除失败：班级下有学生");
            List<Clazz> clazzes = classService.findAllClass();
            model.addAttribute("clazzes",clazzes);
        }
        return "index/tables/classlist";
    }

}
