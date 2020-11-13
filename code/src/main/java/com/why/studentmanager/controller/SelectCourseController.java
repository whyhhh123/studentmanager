package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.SelectCourseService;
import com.why.studentmanager.until.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("msg","dafa");
        model.addAttribute("student",student);
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courselist",courseList);
        return "/index/tables/select";
    }

    @GetMapping("/addSelectCourse")
    @ResponseBody
    public AjaxResult addSelectCourse(SelectCourse selectCourse, Model model){

        AjaxResult ajaxResult = new AjaxResult();

       int result =  selectCourseService.addSelectCourse(selectCourse);

       if(result == 1){
           ajaxResult.setMsg("选课成功");
           ajaxResult.setStatus(true);
       }
       else if(result == 0){

           ajaxResult.setStatus(false);
           ajaxResult.setMsg("课程已满");
       }
       else{
           ajaxResult.setMsg("请勿重新选课");
           ajaxResult.setStatus(false);
       }
       model.addAttribute("msg","asdfadsf");
        return ajaxResult;
    }

    @GetMapping("/selectedlist")
    public String showSelected(HttpServletRequest request,Model model){
        Student student= (Student)request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        List<Course> selectedCourses = selectCourseService.showSelected(student.getSid());
        model.addAttribute("selectedCourses",selectedCourses);
        return "/index/tables/selected";
    }

    @GetMapping("/deleteSelected")
    @ResponseBody
    public AjaxResult deleteSelected(SelectCourse selectCourse){

        AjaxResult ajaxResult = new AjaxResult();

        int result = selectCourseService.deleteBySelectCourse(selectCourse);
        if(result==1){
            ajaxResult.setMsg("退选成功");
            ajaxResult.setStatus(true);
        }
        return ajaxResult;
    }
}
