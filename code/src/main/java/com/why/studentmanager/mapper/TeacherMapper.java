package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> findAllTeacher();
    List<Teacher> addTeacherClassid();

    int setClass_id(int tid);

}
