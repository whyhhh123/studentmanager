package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Teacher;
import com.why.studentmanager.mapper.TeacherMapper;
import com.why.studentmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public int addTeacher(Teacher teacher) {
        int result = teacherMapper.addTeacher(teacher);

        return result;
    }

    @Override
    public Teacher findById(int id) {
        Teacher teacher = teacherMapper.findById(id);
        return teacher;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        int result = teacherMapper.updateTeacher(teacher);

        return result;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteTeacher(int id) {
        int result = teacherMapper.deleteTeacher(id);
        //teacherMapper.alterTable();
        return result;
    }

    @Override
    public Teacher findByTeaceher(Teacher teacher) {
        Teacher teacher1= teacherMapper.findByTeacher(teacher);
        return teacher1;
    }

    @Override
    public int updatePwdByTeacher(Teacher teacher) {
        int result = teacherMapper.updatePwdByTeacher(teacher);
        return result;
    }
}
