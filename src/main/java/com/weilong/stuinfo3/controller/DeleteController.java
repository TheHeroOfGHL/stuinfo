package com.weilong.stuinfo3.controller;

import com.weilong.stuinfo3.model.Student;
import com.weilong.stuinfo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String delete(Model model, Integer spk) {
        Student student = studentService.selectByPk(spk);
        model.addAttribute("student", student);
        return "delete/index";
    }

    @RequestMapping(path = "/delete/do", method = RequestMethod.GET)
    public String delete(Integer spk) {
        studentService.deleteStudentByPk(spk);
        return "delete/success";
    }
}
