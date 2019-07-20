package com.mmz.dao;

import com.mmz.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-07-20  22:37
 * @description:
 */
public interface TeacherDao {

    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher teacher);

    public List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer> ids);

    public int updateTeacher(Teacher teacher);


}
