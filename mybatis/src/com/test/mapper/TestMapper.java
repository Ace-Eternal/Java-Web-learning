package com.test.mapper;

import com.test.entity.Student;
import org.apache.ibatis.annotations.*;

public interface TestMapper {
    @Insert("insert into student values(#{name},#{sid})")
    String addStudent(Student student);
    @Delete("delete from student where sid=#{sid}")
    void deleteStudent(int sid);
    @Select("select *from student where sid=#{sid}")
    String getStudent(int sid);
}
