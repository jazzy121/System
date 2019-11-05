package com.selectCourse.System.controller;

import com.selectCourse.System.dao.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;
}
