package com.why.studentmanager.controller;

import com.why.studentmanager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;



}
