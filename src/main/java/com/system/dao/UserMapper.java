package com.system.dao;


import java.util.List;

import com.system.dataobject.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.*;

@Mapper
@Repository
public interface UserMapper {
    @Delete({
            "delete from user",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into user (id, name, ",
            "pwd, role, gender, ",
            "email, depart, degree, ",
            "occupation, mobile, ",
            "major, classname,gmt_created,gmt_modified)",
            "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{pwd,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
            "#{email,jdbcType=VARCHAR}, #{depart,jdbcType=VARCHAR}, #{degree,jdbcType=VARCHAR}, ",
            "#{occupation,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
            "#{major,jdbcType=VARCHAR}, #{classname,jdbcType=VARCHAR},",
            "now(),now()) "
    })
    int insert(User record);

    @Select({
            "select",
            "id, name, pwd, role, gender, email, depart, degree, occupation, mobile, major, ",
            "classname,gmt_created,gmt_modified",
            "from user",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role", property = "role", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "depart", property = "depart", jdbcType = JdbcType.VARCHAR),
            @Result(column = "degree", property = "degree", jdbcType = JdbcType.VARCHAR),
            @Result(column = "occupation", property = "occupation", jdbcType = JdbcType.VARCHAR),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
            @Result(column = "classname", property = "classname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType =
                    JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String id);

    @Select({
            "select",
            "id, name, pwd, role, gender, email, depart, degree, occupation, mobile, major, ",
            "classname,gmt_created,gmt_modified",
            "from user"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "role", property = "role", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "depart", property = "depart", jdbcType = JdbcType.VARCHAR),
            @Result(column = "degree", property = "degree", jdbcType = JdbcType.VARCHAR),
            @Result(column = "occupation", property = "occupation", jdbcType = JdbcType.VARCHAR),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
            @Result(column = "classname", property = "classname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gmt_created", property = "gmtCreated", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "gmt_modified", property = "gmtModified", jdbcType =
                    JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

    @Update({
            "update user",
            "set name = #{name,jdbcType=VARCHAR},",
            "pwd = #{pwd,jdbcType=VARCHAR},",
            "role = #{role,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR},",
            "depart = #{depart,jdbcType=VARCHAR},",
            "degree = #{degree,jdbcType=VARCHAR},",
            "occupation = #{occupation,jdbcType=VARCHAR},",
            "mobile = #{mobile,jdbcType=VARCHAR},",
            "major = #{major,jdbcType=VARCHAR},",
            "classname = #{classname,jdbcType=VARCHAR},",
            "gmt_created = now(),",
            "gmt_modified = now()",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);

    //老师选出来
    @Select({
            "select",
            "id, name, role, gender, email, depart, degree, occupation, mobile, major ",
            "from user",
            "where role = #{role,jdbcType=VARCHAR}"
    })
    List<User> selectByRole(@Param("role") String role);
}