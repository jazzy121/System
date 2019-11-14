package com.system.controller;

import com.system.dao.*;
import com.system.dataobject.*;
import com.system.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;
import org.springframework.web.servlet.view.*;

@Controller
public class LoginController {

    public static final String SOLT = "Isitapublicpwd";

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public ModelAndView tologin2(@ModelAttribute("account") String account,@ModelAttribute(
            "role") String role) {
        ModelAndView view = new ModelAndView();
        view.addObject("account", account);
        view.addObject("role", role);
        view.setViewName("index");
        return view;
    }

    //get请求就访问login页面
    @GetMapping("/login")
    public ModelAndView tologin(@ModelAttribute("account") String account,@ModelAttribute(
            "role") String role) { //两个ModelAttribute是给页面塞model
        // 页面可以通过属性名得到其值
        ModelAndView view = new ModelAndView();
        view.addObject("account", account);
        view.addObject("role", role);
        view.setViewName("index");
        return view;
    }

    @PostMapping("/login")
    public RedirectView login(RedirectAttributes attributes, @RequestParam("account") String account
            , @RequestParam("pwd") String pwd, @RequestParam("role") String role) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //密码加盐加密
        pwd = MD5Utils.MD5DnCode(MD5Utils.MD5DnCode(pwd, "utf8") + SOLT, "utf8");
//        System.out.println(pwd);
        //登录成功
        if (user != null && pwd.equals(user.getPwd())) {
            //用户鉴权
            //学生
            if (role.equals("student") && user.getRole().equals("student")) {
                view.setUrl("/student?account=" + account);
                return view;
            }
            //老师
            if (role.equals("teacher") && user.getRole().equals("teacher")) {
                view.setUrl("/teacher?account=" + account);
                return view;
            }
            //管理员
            if (role.equals("admin") && user.getRole().equals("admin")) {
                view.setUrl("/admin?account=" + account);
                return view;
            }
        }
        //登录失败
        attributes.addFlashAttribute("account", account);
        attributes.addFlashAttribute("role", role);
        attributes.addFlashAttribute("message", "密码错误!");
        view.setUrl("/login");
        return view;
    }
}
