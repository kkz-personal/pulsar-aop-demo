package com.example.service;

import com.example.mybatis.po.Class;

import java.util.List;

/**
 * @author kmz
 */
public interface ClassService {

    void add(Class c);

    void delete(int id);

    List<Class> getAll();
}
