package com.example.pulsaraopdemo.service;

import com.example.pulsaraopdemo.mybatis.po.StuClass;

import java.util.List;

/**
 * @author kmz
 */

public interface StuClassService {

    void add(StuClass c);

    void delete(int id);

    List<StuClass> getAll();

    StuClass selectOneByClassCno(int cno);

}
