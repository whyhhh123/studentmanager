package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.ClassService;
import com.why.studentmanager.service.StudentService;
import com.why.studentmanager.until.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;
    @Autowired
    public ClassService classService;


    @GetMapping("/index/tables/studentlist")
    public List<Student> studentList(Model model){
        List<Student> students = studentService.findAllStudent();
        System.out.println(students);
        model.addAttribute("sts",students);
        //"/index/tables/studentlist"
        return students;
    }

    @GetMapping("/teacherstudentlist/{tid}")
    public String teacherstudentList(@PathVariable("tid")int tid, Model model, HttpServletRequest request){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("teacher",teacher);
        List<Student> students = studentService.findByTid(tid);
        System.out.println(students);
        model.addAttribute("sts",students);
        return "/index/tables/teacherstudentlist";
    }

    @GetMapping("/addstudent")
    public String getAdd(Model model){

        List<Clazz> clazzes = classService.findAllClass();
        System.out.println("班级 = " + clazzes);
        model.addAttribute("clazzes",clazzes);

        return "index/student/addstudent";
    }

    @PostMapping("/add_student")
    public String postAdd(Student student,Model model){
       // MessageDigest md = MessageDigest.getInstance("MD5");
        //System.out.println(Md5Util.stringToMD5(student.getPassword()));
        student.setPassword(Md5Util.stringToMD5(student.getPassword()));

        int result = studentService.addStudent(student);
        if(result>0){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);
            //System.out.println("student = " + student.getClazz().getName());
            return "index/tables/studentlist";
        }
        else{
            return "index/student/addstudent";
        }
    }

    @GetMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") Integer id, Model model){

        List<Clazz> clazzes = classService.findAllClass();

        model.addAttribute("clazzes",clazzes);
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "index/student/updatestudent";

    }
    @PostMapping("/update_student/{id}")
    public String postUpdate(@PathVariable("id")Integer id, Student student,Model model){
        student.setId(id);
        Student st_init = studentService.findById(id);
        student.setPassword(Md5Util.stringToMD5(student.getPassword()));
        //System.out.println("id = " + id + ", student = " + student );
        int result = studentService.updateStudent(student);

        if(result>0||st_init.equals(student)){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);
            return "index/tables/studentlist";
        }
        else{
            return "index/student/updatestudent";
        }

    }

    @GetMapping("/deletestudent/{class_id}")
    public String getDelete(@PathVariable("class_id")Integer class_id,Model model){
        int result = studentService.deleteStudent(class_id);

        if(result>0){
            List<Student> students = studentService.findAllStudent();
            model.addAttribute("sts",students);

        }
        else{

        }
        return "index/tables/studentlist";
    }
}
