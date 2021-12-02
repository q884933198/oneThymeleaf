package cn.example.onethymeleaf.dao;

import cn.example.onethymeleaf.vo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> getStudent();
    int addStudent(Student student);
    int removeStudent(String id);
    Student getStudentById(String id);

    int updataStudent(Student student);
}
