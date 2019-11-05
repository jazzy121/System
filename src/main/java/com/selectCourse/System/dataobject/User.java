package com.selectCourse.System.dataobject;

/**
 * 
 * @date 2019/11/05
 */
public class User {
    /**
     * id编号
作账户登录编号
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 用户权限限制
student 学生
teacher 老师
admin 管理员
     */
    private String role;

    /**
     * 性别

     */
    private String gender;

    /**
     * 管理员或老师的联系邮箱
     */
    private String email;

    /**
     * 学生院系或者老师院系
     */
    private String depart;

    /**
     * 老师学历
     */
    private String degree;

    /**
     * 老师职称
     */
    private String occupation;

    /**
     * 管理员或老师的联系电话
     */
    private String mobile;

    /**
     * 学生专业
     */
    private String major;

    /**
     * 学生班级
     */
    private String classname;

    /**
     * 该用户选择了的课程id用*分隔
     */
    private String selected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}