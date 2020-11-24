package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.domain.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAllStudent();

    Student findByStudent(Student student);
    Student findById(Integer id);
    Student findBySid(Integer sid);

    int addStudent(Student student);

    int updateStudent(Student student);
    List<Student> findByClassId(int class_id);
    List<Student> findByTid(int tid);
    int deleteStudent(Integer id);
    int updatePwdByStudent(Student student);
    int alterTable();


}
