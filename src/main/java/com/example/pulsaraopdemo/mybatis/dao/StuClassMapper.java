package com.example.pulsaraopdemo.mybatis.dao;

import com.example.pulsaraopdemo.mybatis.po.StuClass;
import com.example.pulsaraopdemo.mybatis.po.StuClassExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StuClassMapper {
    long countByExample(StuClassExample example);

    int deleteByExample(StuClassExample example);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    List<StuClass> selectByExample(StuClassExample example);

    int updateByExampleSelective(@Param("record") StuClass record, @Param("example") StuClassExample example);

    int updateByExample(@Param("record") StuClass record, @Param("example") StuClassExample example);

    List<StuClass> getAll();
}