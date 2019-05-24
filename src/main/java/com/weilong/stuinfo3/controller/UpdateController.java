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
public class UpdateController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/update", method = RequestMethod.GET)
    public String update(Model model, Integer spk) {
        Student student = studentService.selectByPk(spk);
        model.addAttribute("student", student);
        return "update/index";
    }

    @RequestMapping(path = "update/do", method = RequestMethod.POST)
    public String updateDo(Integer spk, @RequestParam(name="sname") String sname, @RequestParam(name="sid") String sid, @RequestParam(name="ssex") String ssex, @RequestParam(name="sage") Integer sage) {
        Student student = new Student();
        student.setSname(sname);
        student.setSid(sid);
        student.setSsex(ssex);
        student.setSage(sage);
        student.setSpk(spk);
        studentService.updateStudent(student);
        return "update/success";
    }
}
