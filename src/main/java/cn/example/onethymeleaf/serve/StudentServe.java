package cn.example.onethymeleaf.serve;

import cn.example.onethymeleaf.dao.StudentMapper;
import cn.example.onethymeleaf.vo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServe {
    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentByid(String id){
        return studentMapper.getStudentById(id);
    };

    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    };

    public int reMoveStudent(String id){
        return studentMapper.removeStudent(id);
    }
    public PageInfo<Student> searchALL(Integer pageNumber, Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<Student> list = studentMapper.getStudent();
        return new PageInfo<Student>(list);
    }

    public int updataStudent(Student student) {
        return studentMapper.updataStudent(student);
    }
}
