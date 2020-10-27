package com.why.studentmanager.service;

import com.why.studentmanager.domain.Clazz;

import java.util.List;

public interface ClassService {
    List<Clazz> findAllClass();
    Clazz findByClass(Integer id);
}
