package com.example.pulsaraopdemo.imp;

import com.example.pulsaraopdemo.mybatis.dao.StudentMapper;
import com.example.pulsaraopdemo.mybatis.po.Student;
import com.example.pulsaraopdemo.mybatis.po.StudentExample;
import com.example.pulsaraopdemo.service.StudentService;
import com.example.pulsaraopdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherService teacherService;

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(int cno) {
        StudentExample example = new StudentExample();
        example.createCriteria().andCnoEqualTo(cno);
        studentMapper.deleteByExample(example);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }
}
