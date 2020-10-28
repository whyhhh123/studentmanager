package com.why.studentmanager.service;


import com.why.studentmanager.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAllTeacher();
    List<Teacher> addTeacherClassid();
    int setClass_id(int tid);
}
