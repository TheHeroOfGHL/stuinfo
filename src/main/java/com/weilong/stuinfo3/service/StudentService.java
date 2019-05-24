package com.weilong.stuinfo3.service;

import com.weilong.stuinfo3.dao.StudentDAO;
import com.weilong.stuinfo3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public int addStudent(Student student) { return studentDAO.addStudent(student); }

    public List<Student> selectAll() { return studentDAO.selectAll(); }

    public Student selectByPk(Integer spk) { return studentDAO.selectByPk(spk); }

    public int updateStudent(Student student) { return studentDAO.updateStudent(student); }

    public int deleteStudentByPk(Integer spk) { return studentDAO.deleteStudentByPk(spk); }

    public List<Student> selectByName(String sname) { return studentDAO.selectByName(sname); }

    public List<Student> selectById(String sid) { return studentDAO.selectById(sid); }

    public List<Student> selectByAll(String sname, String sid, String ssex, Integer sage) { return studentDAO.selectByAll(sname, sid, ssex, sage); }

    public List<Student> selectBySex(String ssex) { return studentDAO.selectBySex(ssex); }

    public List<Student> selectByAge(Integer sage) { return studentDAO.selectByAge(sage); }

    public List<Student> selectBySexAndAge(String ssex, Integer sage) { return studentDAO.selectBySexAndAge(ssex, sage); }
}
