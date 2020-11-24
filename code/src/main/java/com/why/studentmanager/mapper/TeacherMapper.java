package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> findAllTeacher();
    List<Teacher> addTeacherClassid();
    Teacher findByClassid(int class_id);
    Teacher findById(int id);
    int addTeacher(Teacher teacher);
    Teacher findByTeacher(Teacher teacher);
    int setClass_id(int tid);//添加任课班级

    int resetClass_id(int tid);
    int updateTeacher(Teacher teacher);
    int updatePwdByTeacher(Teacher teacher);
    int deleteTeacher(int id);
    int alterTable();


}
