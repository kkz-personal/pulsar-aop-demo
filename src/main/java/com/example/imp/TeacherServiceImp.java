package com.example.imp;

import com.example.mybatis.dao.TeacherMapper;
import com.example.mybatis.po.Teacher;
import com.example.mybatis.po.TeacherExample;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImp implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public void add(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public void delete(int cno) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andIdEqualTo(cno);
        teacherMapper.deleteByExample(example);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }
}
