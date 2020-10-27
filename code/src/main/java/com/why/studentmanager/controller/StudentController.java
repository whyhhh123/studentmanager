package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.ClassService;
import com.why.studentmanager.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;
    @Autowired
    public ClassService classService;


    @GetMapping("/index/tables/datatables")
    public String studentList(Model model){
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("sts",students);

        return "index/tables/datatables";
    }

    @GetMapping("/addstudent")
    public String getAdd(Model model){
        List<Clazz> clazzes = classService.findAllClass();
        System.out.println("班级 = " + clazzes);
        model.addAttribute("clazzes",clazzes);
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

    @GetMapping("/updatestudent/{id}")
    public String updatestudent(@PathVariable("id") Integer id, Model model){
        System.out.println("id = " + id);
        List<Clazz> clazzes = classService.findAllClass();

        model.addAttribute("clazzes",clazzes);
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/index/student/updatestudent";

    }
    @PostMapping("/update_student/{id}")
    public String postUpdate(@PathVariable("id")Integer id, Student student,Model model){
        student.setId(id);
        System.out.println("id = " + id + ", student = " + student + ", model = " + model);
        int result = studentService.updateStudent(student);
        System.out.println(result);
        if(result>0){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);
            return "index/tables/datatables";
        }
        else{
            return "index/student/updatestudent";
        }

    }

    @GetMapping("/deletestudent/{id}")
    public String getDelete(@PathVariable("id")Integer id,Model model){
        int result = studentService.deleteStudent(id);
        if(result>0){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);

        }
        else{

        }
        return "index/tables/datatables";
    }
}
