package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/index/tables/courselist")
    public String courseList(Model model){
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        System.out.println("班级"+courses);
        return "index/tables/courselist";
    }
}
