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
    public RedirectView submit(
                               @RequestParam("account") String account,
                               @RequestParam("course") Integer course,ModelMap modelMap) {

        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用农户存在并且是学生
        if (user != null && user.getRole().equals("student")) {
            //新增了
            Course mycourse = courseMapper.selectByPrimaryKey(course);
            //人满了 不能再选了 或者有问题
            if(mycourse.getSelectedn() >=mycourse.getTotal() ||mycourse.getSelectedn()==null || mycourse.getTotal()==null){
                modelMap.addAttribute("message","人满了!");
            }
            StringBuffer stringBuffer = new StringBuffer(mycourse.getTarget());
            stringBuffer.append(account);
            stringBuffer.append(",");
            mycourse.setTarget(stringBuffer.toString());
            mycourse.setSelectedn(mycourse.getSelectedn()+1);
            courseMapper.updateByPrimaryKey(mycourse);
            view.setUrl("/student?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }
    @PostMapping("/quit")
    public RedirectView quit(
                               @RequestParam("account") String account,
                               @RequestParam("course") Integer course) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用农户存在并且是学生
        if (user != null && user.getRole().equals("student")) {
            //新增了
            Course mycourse = courseMapper.selectByPrimaryKey(course);
            mycourse.setTarget(mycourse.getTarget().replace(account+",",""));
            courseMapper.updateByPrimaryKey(mycourse);
            view.setUrl("/student?account=" + account);
            return view;
        }

        //否则
        view.setUrl("/login");
        return view;
    }

}
