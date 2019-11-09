package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

import javax.validation.*;
import java.util.*;

@Controller
public class AdminController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/admin")
    public String admin(@ModelAttribute("newCourse") Course newCourse,ModelMap modelMap,
            @RequestParam("account") String account) {
        List<CourseDTO> list = courseMapper.queryAll();
        User user = userMapper.selectByPrimaryKey(account);
        User teachers = userMapper.selectByRole("teacher");
        //把所有课程全部返回
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("courses", list);
        modelMap.addAttribute("teachers", teachers);
        return "admin";
    }


    //删除课程
    @PostMapping("/delete")
    public RedirectView delete(RedirectAttributes attributes,
                               @RequestParam("account") String account,
                               @RequestParam("course") Integer course) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用户存在且是管理员
        if (user != null && user.getRole().equals("admin")) {
            //删除课程

            courseMapper.deleteByPrimaryKey(course);

            view.setUrl("/admin?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }

    //新增课程
    @PostMapping("/update")
    public RedirectView update(RedirectAttributes attributes,
                               @RequestParam("account") String account,
                               @Valid Course newCourse,BindingResult result) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用户存在且是管理员
        if (user != null && user.getRole().equals("admin")) {

            //综合判断哪一项 有错
            if(result.hasErrors()){
                attributes.addFlashAttribute("newCourse",newCourse);
                attributes.addFlashAttribute("newCourseError",result);
                view.setUrl("/admin?account=" + account);
                return view;
            }
            //没错 则继续
            //新增了
            Course course = courseMapper.selectByPrimaryKey(newCourse.getId());

            if(course!=null){
                //更新
                courseMapper.updateByPrimaryKey(newCourse);
            }else
            courseMapper.insert(newCourse);

            view.setUrl("/admin?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }
}
