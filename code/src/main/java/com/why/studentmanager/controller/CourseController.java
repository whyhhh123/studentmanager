package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.TeacherService;
import com.why.studentmanager.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/index/tables/courselist")
    public String courseList(Model model){
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        //System.out.println("班级"+courses);
        return "index/tables/courselist";
    }

    @GetMapping("/addcourse")
    public String addCourse(Model model){
        List<Teacher> teachers = teacherService.findAllTeacher();
        model.addAttribute("teachers",teachers);

        return("index/course/addcourse");
    }

    @PostMapping("/addcourse")
    public String addCourse(Course course,Model model){
        int result = courseService.addCourse(course);
        if(result>0){
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "index/tables/courselist";
        }else{
            return "index/course/addcourse";
        }
    }


    @GetMapping("/updatecourse/{id}")
    public String updateCourse(@PathVariable("id")Integer id,Model model){

        Course course = courseService.findById(id);

        model.addAttribute("course",course);
        List<Teacher> teachers = teacherService.findAllTeacher();
        model.addAttribute("teachers",teachers);
        return "index/course/updatecourse";
    }

    @PostMapping("/updatecourse/{id}")
    public String updateCourse(@PathVariable("id")Integer id,Model model,Course course){
        course.setId(id);

        int result = courseService.updateCourse(course);
        if(result>0){
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "index/tables/courselist";
        }
        else{
            return "index/course/updatecourse";
        }
    }

    @GetMapping("/deletecourse/{id}")
    public String deleteCourse(@PathVariable("id")Integer id,Model model){
        int result = courseService.deleteCourse(id);
        if(result>0){
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "index/tables/courselist";
        }
        return "index/tables/courselist";
    }
}
