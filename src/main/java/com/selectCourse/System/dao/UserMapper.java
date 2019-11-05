package com.selectCourse.System.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

@Mapper
@Repository
public interface UserMapper {
    @Delete({
            "delete from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

}
