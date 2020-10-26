package com.why.studentmanager.service;

import com.why.studentmanager.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student findByStudent(Student student);
    int addStudent(Student student);
}
