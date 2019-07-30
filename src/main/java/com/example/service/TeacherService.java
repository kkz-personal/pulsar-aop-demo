package com.example.service;

import com.example.mybatis.po.Teacher;

import java.util.List;

/**
 * @author kmz
 */
public interface TeacherService {

    void add(Teacher teacher);

    void delete(int cno);

    List<Teacher> getAll();
}
