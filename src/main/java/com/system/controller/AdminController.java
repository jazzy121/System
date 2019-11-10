package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.util.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

import javax.validation.*;
import java.text.*;
import java.util.*;

@Controller
public class AdminController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping("/admin")
    public ModelAndView admin(@ModelAttribute("setTime") String setTime, @ModelAttribute(
            "newCourse") Course newCou, ModelMap modelMap,
                              @RequestParam("account") String account) {
        ModelAndView view = new ModelAndView();
        List<CourseDTO> list = courseMapper.queryAll();
        User user = userMapper.selectByPrimaryKey(account);
        List<User> teachers = userMapper.selectByRole("teacher");
        //把所有课程全部返回
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("courses", list);
        modelMap.addAttribute("teachers", teachers);
        view.addObject(BindingResult.class.getName() + ".userForm",
                modelMap.get("userFormError"));
        view.setViewName("admin");
        return view;
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
    public RedirectView update(@RequestParam(value = "setTime",
            defaultValue = "2020-01-15T08:00") String setTime,
                               @RequestParam("account") String account, RedirectAttributes attributes,
                               @Valid Course newCourse, BindingResult result) throws ParseException {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用户存在且是管理员
        if (user != null && user.getRole().equals("admin")) {

            //综合判断哪一项 有错
            if (result.hasErrors()) {
                attributes.addFlashAttribute("newCourse", newCourse);
                attributes.addFlashAttribute("newCourseError", result);
                attributes.addFlashAttribute("setTime", setTime);
                view.setUrl("/admin?account=" + account);
                return view;
            }
            //没错 则继续
            //新增了
            Course course = courseMapper.selectByPrimaryKey(newCourse.getId());
            // 不会再返回了就日期转换
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = sdf.parse(setTime.replace("T"," "));
            newCourse.setTime(date);
            if (course != null) {
                //更新
                newCourse.setSelectedn(course.getSelectedn());
                courseMapper.updateByPrimaryKey(newCourse);
            } else
                courseMapper.insert(newCourse);

            view.setUrl("/admin?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }
}
