package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

import javax.validation.*;

@Controller
public class SignupController {
    public static final String SOLT = "Isitapublicpwd";

    @Autowired
    private UserMapper userMapper;


    //get请求就访问login页面
    @GetMapping("/signup")
    public ModelAndView tosignup(@ModelAttribute("student") User student, Model model) {
        ModelAndView view = new ModelAndView();
        view.addObject(BindingResult.class.getName()+".student",
                model.asMap().get("studentError"));
        view.setViewName("signup");
        return view;
    }

    @PostMapping("/signup")
    public RedirectView signup(RedirectAttributes attributes,
                               @Valid User student, BindingResult result) {
        RedirectView view = new RedirectView();
        //已被注册
        if (userMapper.selectByPrimaryKey(student.getId()) != null) {
            attributes.addFlashAttribute("student", student);
            attributes.addFlashAttribute("studentError", result);
            view.setUrl("/signup");
            return view;
        }
        student.setPwd(MD5Utils.MD5DnCode(MD5Utils.MD5DnCode(student.getPwd(), "utf8") + SOLT,
                "utf8"));
        student.setRole("student");
        //插入
        userMapper.insert(student);
        view.setUrl("/");
        return view;
    }
}
