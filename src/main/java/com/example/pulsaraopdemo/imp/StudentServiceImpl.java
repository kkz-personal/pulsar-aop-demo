package com.example.pulsaraopdemo.imp;

import com.example.pulsaraopdemo.common.enums.PushChannelEnum;
import com.example.pulsaraopdemo.common.push.LazyPush;
import com.example.pulsaraopdemo.mybatis.dao.StuClassMapper;
import com.example.pulsaraopdemo.mybatis.dao.StudentMapper;
import com.example.pulsaraopdemo.mybatis.po.StuClass;
import com.example.pulsaraopdemo.mybatis.po.StuClassExample;
import com.example.pulsaraopdemo.mybatis.po.Student;
import com.example.pulsaraopdemo.mybatis.po.StudentExample;
import com.example.pulsaraopdemo.service.StuClassService;
import com.example.pulsaraopdemo.service.StudentService;
import com.example.pulsaraopdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kmz
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StuClassService stuClassService;

    @Autowired
    StuClassMapper stuClassMapper;

    @Autowired
    PushServiceImpl pushService;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    @LazyPush
    public void addStudentByClass(Student student, int classId) {

        studentMapper.insert(student);

        StuClass stuClass = stuClassService.selectOneByClassCno(classId);
        StuClass stuClass1 = new StuClass();
        if (stuClass != null){
            stuClass1.setStuCno(student.getCno());
            stuClass1.setClassName(stuClass.getClassName());
            stuClass1.setTeacherCno(stuClass.getTeacherCno());
            stuClass1.setClassCno(stuClass.getClassCno());
        }

        this.pushService.send(PushChannelEnum.TEST_CHANNEL,stuClass1,student.getCno());
    }
}
