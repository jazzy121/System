package com.system.dao;


import com.system.dataobject.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.*;
import org.springframework.stereotype.*;

import java.util.*;

@Mapper
@Repository
public interface CourseMapper {
    @Delete({
            "delete from course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into course (id, course_name, ",
            "teacher_id, class_hour, ",
            "credit, time, ",
            "total, selectedN, ",
            "place, priviousC)",
            "values (#{id,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
            "#{teacherId,jdbcType=VARCHAR}, #{classHour,jdbcType=INTEGER}, ",
            "#{credit,jdbcType=INTEGER}, #{time,jdbcType=TIMESTAMP}, ",
            "#{total,jdbcType=INTEGER}, #{selectedn,jdbcType=INTEGER}, ",
            "#{place,jdbcType=VARCHAR}, #{priviousc,jdbcType=INTEGER})"
    })
    int insert(Course record);

    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC ,target",
            "from course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "course_name", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_hour", property = "classHour", jdbcType = JdbcType.INTEGER),
            @Result(column = "credit", property = "credit", jdbcType = JdbcType.INTEGER),
            @Result(column = "time", property = "time", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "selectedN", property = "selectedn", jdbcType = JdbcType.INTEGER),
            @Result(column = "place", property = "place", jdbcType = JdbcType.VARCHAR),
            @Result(column = "priviousC", property = "priviousc", jdbcType = JdbcType.INTEGER),
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR)
    })
    Course selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target",
            "from course"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "course_name", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_hour", property = "classHour", jdbcType = JdbcType.INTEGER),
            @Result(column = "credit", property = "credit", jdbcType = JdbcType.INTEGER),
            @Result(column = "time", property = "time", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "selectedN", property = "selectedn", jdbcType = JdbcType.INTEGER),
            @Result(column = "place", property = "place", jdbcType = JdbcType.VARCHAR),
            @Result(column = "priviousC", property = "priviousc", jdbcType = JdbcType.INTEGER),
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR)
    })
    List<Course> selectAll();

    @Update({
            "update course",
            "set course_name = #{courseName,jdbcType=VARCHAR},",
            "teacher_id = #{teacherId,jdbcType=VARCHAR},",
            "class_hour = #{classHour,jdbcType=INTEGER},",
            "credit = #{credit,jdbcType=INTEGER},",
            "time = #{time,jdbcType=TIMESTAMP},",
            "total = #{total,jdbcType=INTEGER},",
            "selectedN = #{selectedn,jdbcType=INTEGER},",
            "place = #{place,jdbcType=VARCHAR},",
            "priviousC = #{priviousc,jdbcType=INTEGER}",
            "target = #{target,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=LONGVARCHAR}"
    })
    int updateByPrimaryKey(Course record);

    //学生的课
    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target",
            "from course",
            "where find_in_set(target,#{account,jdbcType=VARCHAR})"
    })
    List<Course> selectStudentCourse(@Param("account") String account);

    //老师的课
    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target",
            "from course",
            "where teacher_id = #{account,jdbcType=VARCHAR}"
    })
    List<Course> selectTeacherCourse(@Param("account") String account);
}