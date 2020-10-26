package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAllStudent();

    Student findByStudent(Student student);

    int addStudent(Student student);

    int updateStudent(Student student);


}
