package com.selectCourse.System.controller;

import com.selectCourse.System.dao.*;
import com.selectCourse.System.dataobject.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PagesController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/student")
    public String student(ModelMap modelMap,String account){
        List<Course> list = courseMapper.selectAll();
        String mine = userMapper.selectMineCourse(account);

        //把所有课程全部返回
        modelMap.addAttribute("courses",list);
        modelMap.addAttribute("mine",list);
        return "student";
    }

    @GetMapping("/teacher")
    public String teacher(){

        return "teacher";
    }

    @GetMapping("/admin")
    public String admin(){


        return "admin";
    }
}
