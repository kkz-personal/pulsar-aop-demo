package com.example.imp;

import com.example.mybatis.dao.StudentMapper;
import com.example.mybatis.po.Student;
import com.example.mybatis.po.StudentExample;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImp implements StudentService {

    @Autowired
    StudentMapper studentMapper;

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
