package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Leave;
import com.why.studentmanager.domain.Student;
import com.why.studentmanager.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    public LeaveService leaveService;

    @GetMapping("/index/tables/leavelist")
    public String leaveList(Model model){
        List<Leave> leaveList = leaveService.findAllLeave();
        //System.out.println(leaveList);
        model.addAttribute("leaveList",leaveList);
        return "index/tables/leavelist";
    }

    @GetMapping("/index/tables/studentleavelist/{sid}")
    public String studentleaveList(@PathVariable("sid")int sid,Model model, HttpServletRequest request){
        List<Leave> leaveList = leaveService.findBySid(sid);

        System.out.println(leaveList+""+sid);
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        model.addAttribute("leaveList",leaveList);
        return "index/tables/studentleavelist";
    }

    @GetMapping("/updateleave/{id}")
    public String updateLeave(@PathVariable("id")Integer id,Model model){
        System.out.println("id = " + id );
        Leave leave = leaveService.findById(id);
        if(leave.getStatus() == 1||leave.getStatus() == 2){
            List<Leave> leaveList = leaveService.findAllLeave();

            model.addAttribute("leaveList",leaveList);
            return "index/tables/leavelist";
        }

        model.addAttribute("leave",leave);
        return "index/leave/updateleave";
    }

    @PostMapping("updateleave/{id}")
    public String updateLeave(@PathVariable("id")Integer id,Leave leave,Model model){
        leave.setId(id);
        System.out.println( ", leave = " + leave );
        int result = leaveService.updateLeave(leave);
        System.out.println("result"+result);

            List<Leave> leaveList = leaveService.findAllLeave();

            model.addAttribute("leaveList",leaveList);
            return "index/tables/leavelist";
    }

    @GetMapping("/addleave")
    public String addleave(Model model,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        return "index/leave/addleave";
    }

    @PostMapping("/addleave/{sid}")
    public String addleavelist(@PathVariable("sid")int sid,String info, Model model,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute("student");
        model.addAttribute("student",student);
        Leave leave = new Leave();
        leave.setSid(sid);
        leave.setStatus(0);
        leave.setInfo(info);
        int result = leaveService.addLeave(leave);
        if(result>0){
            List<Leave> leaveList = leaveService.findBySid(sid);
            System.out.println("sid = " + sid + ", info = " + info + ", model = " + model + ", request = " + request);
            System.out.println(leaveList);
            model.addAttribute("leaveList",leaveList);
        }
        return "index/tables/studentleavelist";
    }


    @GetMapping("/deleteleave/{id}")
    public String deleteleave(@PathVariable("id")Integer id,Model model){
        int result = leaveService.deleteById(id);

            List<Leave> leaveList = leaveService.findAllLeave();
            model.addAttribute("leaveList",leaveList);

        return "index/tables/leavelist";
    }
}
