package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Clazz;

import java.util.List;

public interface ClassMapper {
    List<Clazz> findAllClass();
    Clazz findById(Integer id);
    int addClass(Clazz clazz);
    int updateClass(Clazz clazz);
    int deleteClass(Integer id);

}
