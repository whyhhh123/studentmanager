package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/index/tables/datatables")
    public String studentList(Model model){
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("sts",students);

        return "index/tables/datatables";
    }

    @GetMapping("/addstudent")
    public String getAdd(){
        return "/index/student/addstudent";
    }

    @PostMapping("/add_student")
    public String postAdd(Student student,Model model){
        int result = studentService.addStudent(student);
        if(result>0){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);
            return "index/tables/datatables";
        }
        else{
            return "index/student/addstudent";
        }
    }

}
