package com.weilong.stuinfo3.dao;

import com.weilong.stuinfo3.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDAO {

    String tableName = " student ";
    String insertField = " sname,sid,ssex,sage ";
    String selectField = " spk,sdate, " + insertField;

    @Insert({"insert into ", tableName, " ( ", insertField,
            " ) ","values ( #{sname}, #{sid}, #{ssex}, #{sage})"})
    int addStudent(Student student);

    @Select({"select ",selectField, " from ", tableName})
    List<Student> selectAll();

    @Select({"select ", selectField, " from ", tableName, " where spk = #{spk}"})
    Student selectByPk(Integer spk);

    @Update({"update ", tableName, " set sname=#{sname}, ssex=#{ssex}, sage=#{sage} where spk=#{spk}"})
    int updateStudent(Student student);

    @Delete({"delete from ", tableName, " where spk = #{spk}"})
    int deleteStudentByPk(Integer spk);

    @Select({"select ", selectField, " from ", tableName, " where sname=#{sname}"})
    List<Student> selectByName(String sname);

    @Select({"select", selectField, " from ", tableName, " where sid=#{sid}"})
    List<Student> selectById(String sid);

    @Select({"select", selectField, " from ", tableName, " where sname=#{sname} and sid=#{sid} and ssex=#{ssex} and sage=#{sage}"})
    List<Student> selectByAll(String sname, String sid, String ssex, Integer sage);

    @Select({"select", selectField, " from ", tableName, " where ssex=#{ssex}"})
    List<Student> selectBySex(String ssex);

    @Select({"select", selectField, " from ", tableName, " where sage=#{sage}"})
    List<Student> selectByAge(Integer sage);

    @Select({"select ", selectField, " from ", tableName, " where ssex=#{ssex} and sage=#{sage}"})
    List<Student> selectBySexAndAge(String ssex, Integer sage);
}
