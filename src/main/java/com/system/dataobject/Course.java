package com.system.dataobject;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @date 2019/11/05
 */

public class Course {
    /**
     * 课程id
     */
    private Integer id;

    /**
     * 课程名
     */
    @NotNull
    private String courseName;

    /**
     * 授课老师编号
     */
    @NotNull
    private String teacherId;

    /**
     * 课时
     */
    @NotNull
    @Max(4)
    private Integer classHour;

    /**
     * 学分
     */
    @NotNull
    @Max(4)
    private Integer credit;

    /**
     * 开课时间
     */
    @NotNull
    private Date time;

    /**
     * 总人数
     */
    @NotNull
    @Max(4)
    private Integer total;

    /**
     * 已选人数
     */
    private Integer selectedn;

    /**
     * 地点
     */
    @NotNull
    private String place;

    /**
     * 先行课
     */
    private Integer priviousc;

    /**
     * 上课对象 ,分隔
     *
     * @return
     */
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSelectedn() {
        return selectedn;
    }

    public void setSelectedn(Integer selectedn) {
        this.selectedn = selectedn;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getPriviousc() {
        return priviousc;
    }

    public void setPriviousc(Integer priviousc) {
        this.priviousc = priviousc;
    }
}