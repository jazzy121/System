package com.selectCourse.System.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    //get请求就访问login页面
    @GetMapping("/login")
    public String tologin(){

        return "login2";
    }
    @PostMapping("/login")
    public String login(){


        return "login2";
    }
}
