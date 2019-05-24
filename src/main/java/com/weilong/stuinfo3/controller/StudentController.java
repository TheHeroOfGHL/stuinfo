package com.weilong.stuinfo3.controller;

import com.weilong.stuinfo3.model.Student;
import com.weilong.stuinfo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("students", studentService.selectAll());
        return "student/index";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "add/index";
    }

    @RequestMapping(path = "/add/do", method = RequestMethod.POST)
    public String addDo (@RequestParam(name="sname") String sname, @RequestParam(name="sid") String sid, @RequestParam(name="ssex") String ssex, @RequestParam(name = "sage") Integer sage) {
        Student student = new Student();
        student.setSname(sname);
        student.setSid(sid);
        student.setSsex(ssex);
        student.setSage(sage);
        studentService.addStudent(student);
        return "add/success";
    }
}
