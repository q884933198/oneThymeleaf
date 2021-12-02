package cn.example.onethymeleaf.controller;

import cn.example.onethymeleaf.serve.StudentServe;
import cn.example.onethymeleaf.vo.Student;
import cn.example.onethymeleaf.vo.UserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class IndexController {


    @Autowired
    private StudentServe studentServe;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title","传递的标题");
        model.addAttribute("description","传递的描述");
        model.addAttribute("keywords","传递的关键字");
        return "index";
    }
    @GetMapping("/basicTrain")
    public String basic(Model model) {
        UserVO userVO = new UserVO();
        userVO.setAge(21);
        userVO.setSex(1);
        userVO.setIsVip(true);
        userVO.setCreateTime(new Date());
        userVO.setTags(Arrays.asList("Java", "PHP", "Node"));
        userVO.setUsername("lookroot");
        model.addAttribute("user", userVO);
        return "basic";
    }
    @GetMapping("/addStudent")
    public String addStudent() {
        return "addstudent";
    }

    @GetMapping("/shwoStudent/{id}")
    public String shwoStudent(
            @PathVariable("id") String id,
            Model model) {
        System.out.println(id);
        Student student = studentServe.getStudentByid(id);
        model.addAttribute("student",student);

        return "updataStudent";
    }

    @PostMapping("updataStudent")
    @ResponseBody
    public int updataStudent(Student student){
        return studentServe.updataStudent(student);
    }

    @GetMapping("/getstudents")
    @ResponseBody
    public PageInfo<Student> getStudents( Integer pageNumber,
                                    Integer pageSize) {
        return studentServe.searchALL(pageNumber,pageSize);
    }
    @PostMapping("/removeById")
    @ResponseBody
    public int removeStudent(@RequestParam String id) {
        return studentServe.reMoveStudent(id);
    }



    @ResponseBody
    @PostMapping("/addStudent")
    public int addStudent(Student student){
        return studentServe.addStudent(student);
    };
}
