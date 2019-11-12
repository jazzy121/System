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
import org.thymeleaf.util.*;

import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

//    @GetMapping("/student2")
//    public String student2(@ModelAttribute("message") String message, ModelMap modelMap,
//                           @RequestParam("account") String account) {
//        List<CourseDTO> list = courseMapper.queryAll2();
//        List<CourseDTO> mines = courseMapper.selectStudentCourse2(account); //加了逗号才能查 不知为何
//        User user = userMapper.selectByPrimaryKey(account);
//        //把所有课程全部返回
//        modelMap.addAttribute("user", user);
//        modelMap.addAttribute("courses", list);
//        modelMap.addAttribute("mines", mines);
//        return "student";
//    }

    //逻辑重写
    @GetMapping("/student")
    public String student(ModelMap modelMap, @RequestParam("account") String account) {
        List<CourseDTO> list = courseMapper.queryAll();
        for (CourseDTO courseDTO : list) {
            //把老师们的id传进去  得到一个用户名组成的set  转化为string 设置到dto里
            if(courseDTO.getTeacherId()==null){
                continue;
            }
            courseDTO.setName(StringUtils.join(userMapper.selCourseTeacher(courseDTO.getTeacherId()),"~"));
        }
        //做同样的设置name的事
        List<CourseDTO> mines = courseMapper.selectStudentCourse(account); //加了逗号才能查 不知为何
        for (CourseDTO courseDTO : mines) {
            //把老师们的id传进去  得到一个用户名组成的set  转化为string 设置到dto里
            if(courseDTO.getTeacherId()==null){
                continue;
            }
            courseDTO.setName(StringUtils.join(userMapper.selCourseTeacher(courseDTO.getTeacherId()),"~"));
        }
        User user = userMapper.selectByPrimaryKey(account);
        //把所有课程全部返回
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("courses", list);
        modelMap.addAttribute("mines", mines);
        return "student";
    }

    @RequestMapping("/submit")
    public RedirectView submit(
            @RequestParam("account") String account,
            @RequestParam("course") Integer course, RedirectAttributes attributes) {

        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用农户存在并且是学生
        if (user != null && user.getRole().equals("student")) {
            //新增了
            Course mycourse = courseMapper.selectByPrimaryKey(course);
            //人满了 不能再选了 或者有问题
            if (mycourse.getSelectedn() >= mycourse.getTotal() || mycourse.getSelectedn() == null || mycourse.getTotal() == null) {
                attributes.addFlashAttribute("message", "人满了!");
                view.setUrl("/student?account=" + account);
                return view;
            }
            String test = mycourse.getTarget();
            StringBuffer stringBuffer = new StringBuffer();
            if (test != null) {
                stringBuffer.append(test);
                if (test.contains(account)) {
                    attributes.addFlashAttribute("message", "您已选该课程!");
                    view.setUrl("/student?account=" + account);
                    return view;
                }
            }
            stringBuffer.append(account);
            stringBuffer.append(",");
            mycourse.setTarget(stringBuffer.toString());
            mycourse.setSelectedn(mycourse.getSelectedn() + 1);
            courseMapper.updateByPrimaryKey(mycourse);
            view.setUrl("/student?account=" + account);
            return view;
        }
        //否则
        view.setUrl("/login");
        return view;
    }

    @RequestMapping("/quit")
    public RedirectView quit(
            @RequestParam("account") String account,
            @RequestParam("course") Integer course) {
        RedirectView view = new RedirectView();
        User user = userMapper.selectByPrimaryKey(account);
        //用农户存在并且是学生
        if (user != null && user.getRole().equals("student")) {
            //新增了
            Course mycourse = courseMapper.selectByPrimaryKey(course);
            mycourse.setTarget(mycourse.getTarget().replace(account + ",", ""));
            mycourse.setSelectedn(mycourse.getSelectedn() - 1);
            courseMapper.updateByPrimaryKey(mycourse);
            view.setUrl("/student?account=" + account);
            return view;
        }

        //否则
        view.setUrl("/login");
        return view;
    }

}
