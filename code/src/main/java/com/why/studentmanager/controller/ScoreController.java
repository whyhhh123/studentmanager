package com.why.studentmanager.controller;

import com.why.studentmanager.domain.*;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.ScoreService;
import com.why.studentmanager.service.SelectCourseService;
import com.why.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectCourseService selectCourseService;

    @GetMapping("/scorelist")
    public String scoreList(Model model,HttpServletRequest request){
        List<Score> scores = scoreService.findAllScore();
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        model.addAttribute("scores",scores);
        return "/index/score/scorelist";
    }

    @GetMapping("/index/score/studentscore")
    public String studentscoreList(Model model, HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        List<Score> scores = scoreService.findBySid(student.getSid());
        model.addAttribute("scores",scores);

        return "/index/score/studentscorelist";
    }

    @GetMapping("/addscore")
    public String addscore(Model model){
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        return "index/score/addscore";
    }

    @PostMapping("/addscore")
    public String addscore(Score score,Model model){
        Student student = studentService.findBySid(score.getSid());
        System.out.println(student);
        if(student==null){
            model.addAttribute("notstudnet","请输入正确学号");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/score/addscore";
        }
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setCourseId(score.getCourseId());
        selectCourse.setSid(score.getSid());
        selectCourse= selectCourseService.findSelect(selectCourse);
        if(selectCourse==null){
            model.addAttribute("msg","该学生未选修此课程");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/score/addscore";
        }
        Integer rs = scoreService.findByScore(score);
        if(rs==null ){
            score.setClassId(student.getClass_id());
            int result = scoreService.addScore(score);

                List<Score> scores = scoreService.findAllScore();
                model.addAttribute("scores",scores);

            return "/index/score/scorelist";
        }
        else{
            model.addAttribute("msg","该同学此门课程已经登记成绩");
            List<Course> courses = courseService.findAllCourse();
            model.addAttribute("courses",courses);
            return "/index/score/addscore";
        }

    }

    @GetMapping("updatescore/{id}")
    public String updateScore(@PathVariable("id")int id,Model model){
        Score score = scoreService.findById(id);
        model.addAttribute("score",score);
        return "/index/score/updatescore";
    }

    @PostMapping("updatescore/{id}")
    public String updateScore(@PathVariable("id")int id,Score score, Model model){
        Score sc = scoreService.findById(id);
        sc.setScore(score.getScore());
        sc.setRemark(score.getRemark());
        int result = scoreService.updateScore(sc);
        List<Score> scores = scoreService.findAllScore();
        model.addAttribute("scores",scores);
        return "/index/score/scorelist";

    }

    @GetMapping("/deletescore/{id}")
    public String deleteScore(@PathVariable("id")int id,Model model){
        int result = scoreService.deleteById(id);
        if(result>0){
            List<Score> scores = scoreService.findAllScore();
            model.addAttribute("scores",scores);
        }
        return "/index/score/scorelist";
    }

    @GetMapping("/teacherscorelist")
    public String teacherscorelist(HttpServletRequest request,Model model){
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courses = courseService.findByTid(teacher.getTid());
        model.addAttribute("courses",courses);
        List<Score> scores = scoreService.findByTid(teacher.getTid());
        model.addAttribute("scores",scores);
        return "/index/score/teacherscorelist";
    }

    @GetMapping("/findByCourseId")
    public String findByCourseId(Model model,int courseId,HttpServletRequest request){
        List<Score> scores = scoreService.findByCourseId(courseId);
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        List<Course> courses = courseService.findByTid(teacher.getTid());
        model.addAttribute("courses",courses);
        model.addAttribute("scores",scores);
        return "/index/score/teacherscorelist";
    }


}
