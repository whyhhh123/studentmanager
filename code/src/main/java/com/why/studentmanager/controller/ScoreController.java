package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.Score;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.CourseService;
import com.why.studentmanager.service.ScoreService;
import com.why.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/scorelist")
    public String scoreList(Model model){

        List<Score> scores = scoreService.findAllScore();
        model.addAttribute("scores",scores);
        List<Course> courses = courseService.findAllCourse();
        model.addAttribute("courses",courses);
        return "/index/score/scorelist";
    }

    @PostMapping("/addscore")
    public String addscore(Score score,Model model){
        Student student = studentService.findBySid(score.getSid());
        score.setClassId(student.getClass_id());
        int result = scoreService.addScore(score);
        if(result >0)
        {
            List<Score> scores = scoreService.findAllScore();
            model.addAttribute("scores",scores);
        }
        else{

        }
        return "/index/score/scorelist";
    }
    @GetMapping("/deletescore/{id}")
    public String deleteScore(@PathVariable("id")int id,Model model){
        int result = scoreService.deleteById(id);
        if(result>0){
            List<Score> scores = scoreService.findAllScore();
            model.addAttribute("scores",scores);
        }
        return "index/score/scorelist";
    }
}
