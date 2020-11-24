package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.domain.Student;

import java.util.List;

public interface ClassMapper {
    List<Clazz> findAllClass();
    Clazz findById(Integer class_id);
    int addClass(Clazz clazz);
    int updateClass(Clazz clazz);
    int deleteClass(Integer class_id);
    int setTid();
    int alterTable();

}
