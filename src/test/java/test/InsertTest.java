package test;
import com.example.pulsaraopdemo.PulsarAopDemoApplication;
import com.example.pulsaraopdemo.mybatis.po.StuClass;
import com.example.pulsaraopdemo.mybatis.po.Student;
import com.example.pulsaraopdemo.mybatis.po.Teacher;
import com.example.pulsaraopdemo.service.StuClassService;
import com.example.pulsaraopdemo.service.StudentService;
import com.example.pulsaraopdemo.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PulsarAopDemoApplication.class)

public class InsertTest {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StuClassService stuClassService;

    @Autowired
    StudentService studentService;

    @Test
    public void studentInsert(){
       Student student = new Student();
       student.setCno(1234567894);
       student.setName("绯红女巫");
       student.setSex("n");

       studentService.add(student);
    }
    @Test
    public void classInsert(){
        StuClass c = new StuClass();

        c.setClassName("x战警");
        c.setStuCno(1234567893);
        c.setClassCno(001);
        c.setTeacherCno(1);
        stuClassService.add(c);

    }
    @Test
    public void teacherInsert(){
        Teacher teacher = new Teacher();
        teacher.setAge(29);
        teacher.setName("奇异博士");
        teacher.setSex("w");
        teacher.setTeachTime(6);
        teacher.setPhone(1300000001);

        teacherService.add(teacher);
    }

    @Test
    public void gerAll(){
        System.out.println(studentService.getAll());
    }
}
