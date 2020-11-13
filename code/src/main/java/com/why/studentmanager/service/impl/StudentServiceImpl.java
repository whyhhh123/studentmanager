package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Student;
import com.why.studentmanager.mapper.StudentMapper;
import com.why.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = studentMapper.findAllStudent();
        return students;
    }

    @Override
    public Student findByStudent(Student student) {
        Student st = studentMapper.findByStudent(student);
        return st;
    }

    @Override
    public int addStudent(Student student) {
        int result = studentMapper.addStudent(student);
        return result;
    }

    @Override
    public int updateStudent(Student student) {
        int result = studentMapper.updateStudent(student);
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteStudent(Integer id) {
        int result = studentMapper.deleteStudent(id);
        studentMapper.alterTable();
        return result;
    }

    @Override
    public Student findBySid(int sid) {
        Student student = studentMapper.findBySid(sid);
        return student;
    }

    @Override
    public Student findById(Integer id) {
        Student student = studentMapper.findById(id);
        return student;
    }
}
