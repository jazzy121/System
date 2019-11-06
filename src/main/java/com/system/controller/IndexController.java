package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @RequestMapping("/test")
    @ResponseBody
    public List<Course> test(){
        List<Course> list = courseMapper.selectAll();
        return list;
    }

}
