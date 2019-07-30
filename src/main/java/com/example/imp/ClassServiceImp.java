package com.example.imp;

import com.example.mybatis.dao.ClassMapper;
import com.example.mybatis.po.Class;
import com.example.mybatis.po.ClassExample;
import com.example.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.repository.ClassRepository;

import java.util.List;

/**
 * @author kmz
 */
public class ClassServiceImp implements ClassService {

    @Autowired
    ClassMapper classMapper;

    @Override
    public void add(Class c) {
        classMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        ClassExample example = new ClassExample();
        example.createCriteria().andIdEqualTo(id);
        classMapper.deleteByExample(example);
    }

    @Override
    public List<Class> getAll() {
      return classMapper.getAll();
    }
}
