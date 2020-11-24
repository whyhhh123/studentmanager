package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("index/tables/courselist")
    public String courseList(Model model){
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        return "index/tables/courselist";
    }

    @GetMapping("/teachercourselist/{tid}")
    public String courseList(@PathVariable("tid")int tid, HttpServletRequest request, Model model){
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("teacher",teacher);
        List<Course> courses = courseService.findByTid(tid);
        model.addAttribute("courses",courses);
        return "index/tables/teachercourselist";
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
        System.out.println(result);
        if(result>0){

            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "index/tables/courselist";
        }
        else{
            model.addAttribute("nodelete","删除失败：课程下已有学生选课");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "index/tables/courselist";
        }

    }
}
