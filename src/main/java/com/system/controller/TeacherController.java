package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TeacherController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/teacher")
    public String teacher(ModelMap modelMap,@RequestParam("account") String  account){
        List<Course> mines = courseMapper.selectTeacherCourse(account); //加了逗号才能查 不知为何
        User user = userMapper.selectByPrimaryKey(account);
        //把所有课程全部返回
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("mines",mines);
        return "teacher";
    }


}
