package com.example.pulsaraopdemo.imp;

import com.example.pulsaraopdemo.mybatis.dao.StuClassMapper;
import com.example.pulsaraopdemo.mybatis.po.StuClass;
import com.example.pulsaraopdemo.mybatis.po.StuClassExample;
import com.example.pulsaraopdemo.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kmz
 */
@Service
public class StuClassServiceImpl implements StuClassService {

    @Autowired
    StuClassMapper classMapper;

    @Override
    public void add(StuClass c) {
        classMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        StuClassExample example = new StuClassExample();
        example.createCriteria().andIdEqualTo(id);
        classMapper.deleteByExample(example);
    }

    @Override
    public List<StuClass> getAll() {
      return classMapper.getAll();
    }
}
