package com.example.pulsaraopdemo.service;

import com.example.pulsaraopdemo.mybatis.po.Teacher;

import java.util.List;

/**
 * @author kmz
 */
public interface TeacherService {

    void add(Teacher teacher);

    void delete(int cno);

    List<Teacher> getAll();
}
