package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SelectCourseController {
    @Autowired
    SelectCourseService selectCourseService;
    @Autowired
    CourseService courseService;

    @GetMapping("/selectlist")
    public String selectlist(Model model, HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courselist",courseList);
        return "/index/selectcourse/select";
    }

    @GetMapping("/addSelectCourse/{sid}/{course_id}")
    public String addSelectCourse(@PathVariable("sid")int sid,@PathVariable("course_id")int course_id, Model model,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setSid(sid);
        selectCourse.setCourseId(course_id);
        System.out.println("selectCourse = " + selectCourse);
        int result =  selectCourseService.addSelectCourse(selectCourse);
       if(result == 1){
           model.addAttribute("msg","选课成功");
       }
       else if(result == 0){
           model.addAttribute("msg","课程已满");

       }
       else{
           model.addAttribute("msg","请勿重新选课");

       }
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courselist",courseList);
        return "/index/tables/select";
    }

    @GetMapping("/selectedlist")
    public String showSelected(HttpServletRequest request,Model model){
        Student student= (Student)request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        List<Course> selectedCourses = selectCourseService.showSelected(student.getSid());
        model.addAttribute("selectedCourses",selectedCourses);
        return "/index/tables/selected";
    }

    @GetMapping("/deleteSelected/{sid}/{course_id}")
    public String deleteSelected(@PathVariable("sid")int sid,@PathVariable("course_id")int course_id, Model model,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setSid(sid);
        selectCourse.setCourseId(course_id);
        int result = selectCourseService.deleteBySelectCourse(selectCourse);
        if(result==1){
            model.addAttribute("msg","退选成功");
        }
        else if(result == 0){
            model.addAttribute("msg","您未选择此课程");
        }
        List<Course> selectedCourses = selectCourseService.showSelected(student.getSid());
        model.addAttribute("selectedCourses",selectedCourses);

        return "/index/tables/selected";
    }
}
