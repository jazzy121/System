package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/student")
    public String student(ModelMap modelMap, @RequestParam("account") String account) {
        List<CourseDTO> list = courseMapper.queryAll();
        List<CourseDTO> mines = courseMapper.selectStudentCourse(account); //加了逗号才能查 不知为何
        User user = userMapper.selectByPrimaryKey(account);
        //把所有课程全部返回
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("courses", list);
        modelMap.addAttribute("mines", mines);
        return "student";
    }


    @PostMapping("/submit")
    public RedirectView submit(RedirectAttributes attributes,
                               @RequestParam("account") String account,
                               @RequestParam("course") Integer course) {

        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用农户存在并且是学生
        if (user != null && user.getRole().equals("student")) {

            //新增了
            Course mycourse = courseMapper.selectByPrimaryKey(course);
            StringBuffer stringBuffer = new StringBuffer(mycourse.getTarget());
            stringBuffer.append(account);
            stringBuffer.append(",");
            mycourse.setTarget(stringBuffer.toString());
            courseMapper.updateByPrimaryKey(mycourse);
            view.setUrl("/student?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }

}
