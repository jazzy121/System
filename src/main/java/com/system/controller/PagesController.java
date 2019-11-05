package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
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
    public String student(ModelMap modelMap,@RequestParam("account") String  account){
        List<Course> list = courseMapper.selectAll();
        List<Course> mine = courseMapper.selectStudentCourse(account);

        //把所有课程全部返回
        modelMap.addAttribute("acoount",account);
        modelMap.addAttribute("courses",list);
        modelMap.addAttribute("mine",list);
        return "student";
    }

    @GetMapping("/teacher")
    public String teacher(ModelMap modelMap,@RequestParam("account") String  account){
        List<Course> list = courseMapper.selectAll();
        List<Course> mine = courseMapper.selectTeacherCourse(account);

        //把所有课程全部返回
        modelMap.addAttribute("acoount",account);
        modelMap.addAttribute("courses",list);
        modelMap.addAttribute("mine",list);
        return "teacher";
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap,@RequestParam("account") String  account){
        List<Course> list = courseMapper.selectAll();

        //把所有课程全部返回
        modelMap.addAttribute("acoount",account);
        modelMap.addAttribute("courses",list);
        return "admin";
    }
}
