package com.system.dao;


import com.system.dataobject.*;
import com.system.dto.*;
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
            "place, priviousC,target,gmt_created,gmt_modified)",
            "values (#{id,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
            "#{teacherId,jdbcType=VARCHAR}, #{classHour,jdbcType=INTEGER}, ",
            "#{credit,jdbcType=INTEGER}, #{time,jdbcType=TIMESTAMP}, ",
            "#{total,jdbcType=INTEGER}, #{selectedn,jdbcType=INTEGER}, ",
            "#{place,jdbcType=VARCHAR}, #{priviousc,jdbcType=INTEGER},",
            "#{target,jdbcType=LONGVARCHAR}, now(),now())"
    })
    int insert(Course record);

    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC ,target,gmt_created,gmt_modified",
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
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    Course selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target,gmt_created,gmt_modified",
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
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Course> selectAll();

    @Update({
            "update course",
            "set course_name = #{courseName,jdbcType=VARCHAR},",
            "class_hour = #{classHour,jdbcType=INTEGER},",
            "credit = #{credit,jdbcType=INTEGER},",
            "time = #{time,jdbcType=TIMESTAMP},",
            "total = #{total,jdbcType=INTEGER},",
            "selectedN = #{selectedn,jdbcType=INTEGER},",
            "place = #{place,jdbcType=VARCHAR},",
            "priviousC = #{priviousc,jdbcType=INTEGER},",
            "gmt_created = #{gmtCreated,jdbcType=TIMESTAMP},",
            "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
            "teacher_id = #{teacherId,jdbcType=LONGVARCHAR},",
            "target = #{target,jdbcType=LONGVARCHAR},",
            "gmt_created = now(),",
            "gmt_modified = now()",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);

//    @Select({
//            "select",
//            "course.id, user.name, course_name, teacher_id, class_hour, credit, time, total, ",
//            "selectedN,place, priviousC,target,course.gmt_created,course.gmt_modified",
//            "from course",
//            "left join user on  find_in_set(user.id,teacher_id)"
//    })
//    @ResultMap("dto")
//    List<CourseDTO> queryAll2();
//
//    //学生的课
//    @Select({
//            "select",
//            "course.id, user.name, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
//            "priviousC,target,course.gmt_created,course.gmt_modified",
//            "from course",
//            "join user on  find_in_set(user.id,teacher_id)",
//            "where find_in_set(#{account,jdbcType=VARCHAR},target)"
//    })
//    @ResultMap("dto")
//    List<CourseDTO> selectStudentCourse2(@Param("account") String account);

    //老师的课
    @Select({
            "select",
            "course.id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place,",
            "priviousC,target,gmt_created,gmt_modified",
            "from course",
            "where find_in_set(#{account,jdbcType=VARCHAR},teacher_id)"
    })
    @Results(id = "dto", value = {
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
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Course> selectTeacherCourse(@Param("account") String account);


    //逻辑重写
    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target,gmt_created,gmt_modified",
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
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<CourseDTO> queryAll();

    //逻辑重写
    @Select({
            "select",
            "id, course_name, teacher_id, class_hour, credit, time, total, selectedN, place, ",
            "priviousC,target,gmt_created,gmt_modified",
            "from course",
            "where find_in_set(#{account,jdbcType=VARCHAR},target)"
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
            @Result(column = "target", property = "target", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.TIMESTAMP)
    })
    List<CourseDTO> selectStudentCourse(String account);
}