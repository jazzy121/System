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
    @NotNull(message="课程id不能为空!")
    private Integer id;

    /**
     * 课程名
     */
    @NotNull(message="课程名不能为空!")
    private String courseName;

    /**
     * 授课老师编号
     */
    @NotNull(message="授课老师编号不能为空!")
    private String teacherId;

    /**
     * 课时
     */
    @NotNull(message="课时不能为空!")
    private Integer classHour;

    /**
     * 学分
     */
    @NotNull(message="学分不能为空!")
    private Integer credit;

    /**
     * 开课时间
     */
    private Date time;

    /**
     * 总人数
     */
    @NotNull(message="总人数不能为空!")
    private Integer total=0;

    /**
     * 已选人数
     */
    private Integer selectedn=0;

    /**
     * 地点
     */
    @NotNull(message="地点不能为空!")
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

    /**
     * 创建日期
     * @return
     */
    private String gmtCreated;

    /**
     * 修改日期
     * @return
     */
    private String gmtModified;

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

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }
}