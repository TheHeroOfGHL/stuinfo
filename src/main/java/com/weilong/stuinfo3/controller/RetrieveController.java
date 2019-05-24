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
public class RetrieveController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/retrieve", method = RequestMethod.POST)
    public String retrieve(Model model, @RequestParam(name = "sname") String sname, @RequestParam(name="sid") String sid, @RequestParam(name="ssex") String ssex, @RequestParam(name="sage") Integer sage) {
        if (!ssex.trim().isEmpty() && !sage.toString().trim().isEmpty()) {
            model.addAttribute("students", studentService.selectBySexAndAge(ssex, sage));
        } else if (sname != null && !sname.trim().isEmpty()) {
            model.addAttribute("students", studentService.selectByName(sname));
        } else if (sid != null && !sid.trim().isEmpty()) {
            model.addAttribute("students", studentService.selectById(sid));
        } else if (ssex != null && !ssex.trim().isEmpty()) {
            model.addAttribute("students", studentService.selectBySex(ssex));
        } else {
            model.addAttribute("students", studentService.selectByAge(sage));
        }
        return "student/index";
    }
}
