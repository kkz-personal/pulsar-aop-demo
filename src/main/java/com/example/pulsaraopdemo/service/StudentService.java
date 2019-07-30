package com.example.pulsaraopdemo.service;

import com.example.pulsaraopdemo.mybatis.po.Student;

import java.util.List;

/**
 * @author kmz
 */
public interface StudentService {

    void add(Student student);

    void delete(int cno);

    List<Student> getAll();
}
