package com.example.pulsaraopdemo.imp;

import com.example.pulsaraopdemo.mybatis.dao.TeacherMapper;
import com.example.pulsaraopdemo.mybatis.po.Teacher;
import com.example.pulsaraopdemo.mybatis.po.TeacherExample;
import com.example.pulsaraopdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
