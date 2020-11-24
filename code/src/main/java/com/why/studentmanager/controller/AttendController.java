package com.why.studentmanager.controller;

import com.alibaba.fastjson.JSON;
import com.why.studentmanager.domain.*;
import com.why.studentmanager.service.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AttendController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private AttendService attendService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectCourseService selectCourseService;


    @GetMapping("/attendlist")
    public String attendlist(Model model, HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        model.addAttribute("admin",admin);
        List<Attendance> attendanceList = attendanceService.findAll();

        model.addAttribute("attendanceList",attendanceList);
        return "/index/tables/attedlist";
    }

    @GetMapping("/addattend")
    public String addattend(Model model, HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        model.addAttribute("admin",admin);
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        return "/index/attend/addattend";
    }

    @PostMapping("/addattend")
    public String addattend(SelectCourse selectCourse, Model model,HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        model.addAttribute("admin",admin);
        Student student = studentService.findBySid(selectCourse.getSid());
        int couseId = selectCourse.getCourseId();

        if(student==null){
            model.addAttribute("notstudnet","请输入正确学号");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/attend/addattend";
        }
        selectCourse= selectCourseService.findSelect(selectCourse);
        if(selectCourse==null){
            model.addAttribute("msg","该学生未选修此课程");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/attend/addattend";
        }
        Attendance attendance = new Attendance();
        attendance.setSid(selectCourse.getSid());
        attendance.setCourseId(couseId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
        Date now = new Date();
        String dateString = sdf.format(now);
        attendance.setTime(dateString);
        List<Attendance> attendances= attendanceService.findByAttend(attendance);
        if(attendances.size()==0){//或者attendances.size()==老师发布签到的次数-1
            int result = attendanceService.addAttend(attendance);
            if(result>0){
                model.addAttribute("success","签到成功");
            }
            else{
                model.addAttribute("fail","签到失败");
            }
        }
        else {
            model.addAttribute("allready","请勿重复签到");//判断是否学生这门课是否进行签到，与老师发布的签到次数一致时弹出已签到
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);

            return "/index/attend/addattend";
        }
        List<Attendance> attendanceList = attendanceService.findAll();
        model.addAttribute("attendanceList",attendanceList);
        return "/index/tables/attedlist";
    }

    @PostMapping("/addattend/{sid}/{courseId}")
    public String addattend(@PathVariable("sid")int sid,@PathVariable("courseId")int courseId, Model model,HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        model.addAttribute("admin",admin);
        Attendance attendance = new Attendance();
        attendance.setSid(sid);
        attendance.setCourseId(courseId);
        Student student = studentService.findBySid(sid);

        if(student==null){
            model.addAttribute("notstudnet","请输入正确学号");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/attend/addattend";
        }
        SelectCourse selectCourse =new SelectCourse();
        selectCourse.setSid(sid);
        selectCourse.setCourseId(courseId);
        selectCourse= selectCourseService.findSelect(selectCourse);
        if(selectCourse==null){
            model.addAttribute("msg","该学生未选修此课程");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/attend/addattend";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
        Date now = new Date();
        String dateString = sdf.format(now);
        attendance.setTime(dateString);

        List<Attendance> attendances= attendanceService.findByAttend(attendance);
        if(attendances.size()==0){//或者attendances.size()==老师发布签到的次数-1
            int result = attendanceService.addAttend(attendance);
            if(result>0){
                model.addAttribute("success","签到成功");
            }
            else{
                model.addAttribute("fail","签到失败");
            }
        }
        else {
            model.addAttribute("allready","请勿重复签到");//判断是否学生这门课是否进行签到，与老师发布的签到次数一致时弹出已签到
        }
        return "/index/tables/attedlist";//返回学生的签到列表
    }

    @GetMapping("/teacheratteendlist")
    public String teacherAttendList(Model model){
        return "/index/attend/teacherattendlist";
    }

    @GetMapping("/newattend")
    public String newattend(Model model,HttpServletRequest request){
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courses= courseService.findByTid(teacher.getTid());
        model.addAttribute("courses",courses);
        return "/index/attend/newattend";
    }

    @PostMapping("/newattend")
    public String newattend(Attend attend,Model model,HttpServletRequest request){
        int result = attendService.findByAttend(attend);
        if(result != 0){
            Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
            List<Attend> attends = attendService.findByTid(teacher.getTid());
            model.addAttribute("attends", attends);
            return "/index/attend/teacherattendlist";
        }
        int count = attendService.newattend(attend);
        attend.setCount(count);
        List<Attend> attends1  = attendService.findByCourseId(7);

        List<Attendance> attendances = attendanceService.findByCourseIdAttend(attend);

        int rs = attendService.batchInsert(attendances);
        if(rs>0){
            Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
            List<Attend> attends = attendService.findByTid(teacher.getTid());
            model.addAttribute("attends", attends);
            return "/index/attend/teacherattendlist";
        }
        else{
            model.addAttribute("msg","添加失败");
            return "/index/attend/newattend";
        }

    }

    @GetMapping("/teaccherattendlist")
    public String teacherattendlist(Model model,HttpServletRequest request){
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Attend> attends = attendService.findByTid(teacher.getTid());
        model.addAttribute("attends", attends);
        return "/index/attend/teacherattendlist";

    }

    @GetMapping("/student/showattend")
    public String showStudentAttend( Model model,HttpServletRequest request){
        List<Attendance> attendances = attendanceService.findBySid(((Student) request.getSession().getAttribute("student")).getSid());
        model.addAttribute("attendances",attendances);
        return "/index/attend/studentattendlist";
    }

    @GetMapping("/attendontime/{id}")
    public String attendOnTime(@PathVariable("id")int id,Model model,HttpServletRequest request){
        int rs = attendanceService.attendOnTime(id);
        if(rs == 1){
            model.addAttribute("msg","签到成功");
        }
        else if(rs == 2){
            model.addAttribute("msg","签到时间已过");
        }
        else if(rs == 3){
            model.addAttribute("msg","签到时间未到");
        }
        else{
            model.addAttribute("msg","请勿重复签到");
        }

        List<Attendance> attendances = attendanceService.findBySid(((Student) request.getSession().getAttribute("student")).getSid());
        model.addAttribute("attendances",attendances);
        return "/index/attend/studentattendlist";
    }



}
