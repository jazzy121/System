package com.selectCourse.System.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Mapper
@Repository
public interface CourseMapper {
    @Delete({
            "delete from course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
}
