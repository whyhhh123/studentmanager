package com.why.studentmanager.controller;

import com.why.studentmanager.domain.Leave;
import com.why.studentmanager.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/updateleave/{id}")
    public String updateLeave(@PathVariable("id")Integer id,Model model){

        Leave leave = leaveService.findById(id);
        if(leave.getStatus() == 1||leave.getStatus() == 2){
            List<Leave> leaveList = leaveService.findAllLeave();
            System.out.println(leaveList);
            model.addAttribute("leaveList",leaveList);
            return "index/tables/leavelist";
        }

        model.addAttribute("leave",leave);
        return "index/leave/updateleave";
    }

    @PostMapping("updateleave/{id}")
    public String updateLeave(@PathVariable("id")Integer id,Leave leave,Model model){
        leave.setId(id);

        int result = leaveService.updateLeave(leave);

        if(result>0){
            List<Leave> leaveList = leaveService.findAllLeave();
            System.out.println(leaveList);
            model.addAttribute("leaveList",leaveList);
            return "index/tables/leavelist";
        }
        return "index/tables/leavelist";
    }

    @GetMapping("/deleteleave/{id}")
    public String deleteleave(@PathVariable("id")Integer id,Model model){
        int result = leaveService.deleteById(id);
        if(result>0) {
            List<Leave> leaveList = leaveService.findAllLeave();
            model.addAttribute("leaveList",leaveList);
        }
        return "index/tables/leavelist";

    }
}
