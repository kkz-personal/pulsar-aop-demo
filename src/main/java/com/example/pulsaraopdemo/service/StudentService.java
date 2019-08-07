package com.example.pulsaraopdemo.service;

import com.example.pulsaraopdemo.mybatis.po.Student;

import java.util.List;

/**
 * @author kmz
 */
public interface StudentService {

    /**
     * 新添加学生
     * @param student
     */
    void add(Student student);

    void delete(int cno);

    List<Student> getAll();

    /**
     * 新增加一个学生 并分配班级
     * @param student
     * @param classCno 班级编号
     */
    void addStudentByClass(Student student, int classCno);
}
