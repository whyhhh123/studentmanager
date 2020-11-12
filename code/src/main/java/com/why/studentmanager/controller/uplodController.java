package com.why.studentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uplodController {
    @GetMapping("/uplod")
    public String uplod(MultipartFile file){
        System.out.println("adhfjahfkah");
        return "/uplod";
    }
}
