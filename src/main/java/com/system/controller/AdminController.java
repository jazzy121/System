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
public class AdminController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/admin")
    public String admin(ModelMap modelMap, @RequestParam("account") String account) {
        List<CourseDTO> list = courseMapper.queryAll();
        User user = userMapper.selectByPrimaryKey(account);
        //把所有课程全部返回
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("courses", list);
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
                               Course newcourse) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用户存在且是管理员
        if (user != null && user.getRole().equals("admin")) {
            //新增了
            Course course = courseMapper.selectByPrimaryKey(newcourse.getId());

            if(course!=null){
                //更新
                courseMapper.updateByPrimaryKey(newcourse);
            }else
            courseMapper.insert(newcourse);

            view.setUrl("/admin?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }
}
