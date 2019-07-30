package com.example.pulsaraopdemo.mybatis.dao;

import com.example.pulsaraopdemo.mybatis.po.Teacher;
import com.example.pulsaraopdemo.mybatis.po.TeacherExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author kmz
 */
@Mapper
@Repository
public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    List<Teacher> getAll();
}