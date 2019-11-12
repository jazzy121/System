package com.selectCourse.System.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
