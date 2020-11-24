package com.why.studentmanager.service;


import com.why.studentmanager.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAllTeacher();
    List<Teacher> addTeacherClassid();
    Teacher findByClassid(int class_id);
    int setClass_id(int tid);
    int resetClass_id(int tid);
    int addTeacher(Teacher teacher);
    Teacher findById(int id);
    int updateTeacher(Teacher teacher);
    int deleteTeacher(int id);
    Teacher findByTeaceher(Teacher teacher);
    int updatePwdByTeacher(Teacher teacher);



}
