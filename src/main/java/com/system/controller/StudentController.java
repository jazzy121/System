package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

@Controller
public class StudentController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    @PostMapping("/post")
    public RedirectView post(RedirectAttributes attributes,
                             @RequestParam("account") String account,
                             @RequestParam("course") String course){

        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);

        //你写



        view.setUrl("/student?account="+account);
        return view;
    }

}
