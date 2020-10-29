package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.mapper.TeacherMapper;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAllTeacher() {
        List<Teacher> teachers = teacherMapper.findAllTeacher();

        return teachers;
    }

    @Override
    public List<Teacher> addTeacherClassid() {
        List<Teacher> teachers = teacherMapper.addTeacherClassid();
        return teachers;
    }

    @Override
    public Teacher findByClassid(int class_id) {
        Teacher teacher = teacherMapper.findByClassid(class_id);
        return teacher;
    }

    @Override
    public int setClass_id(int id) {
        int result = teacherMapper.setClass_id(id);
        return result;

    }

    @Override
    public int resetClass_id(int tid) {
        int result = teacherMapper.resetClass_id(tid);
        return result;
    }
}