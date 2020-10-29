package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Clazz;
import com.why.studentmanager.mapper.ClassMapper;
import com.why.studentmanager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Clazz> findAllClass() {
        List<Clazz> clazzes = classMapper.findAllClass();
        return clazzes;
    }

    @Override
    public Clazz findById(Integer id) {
        Clazz clazz = classMapper.findById(id);
        return clazz;
    }

    @Override
    public int addClass(Clazz clazz) {
        int result =classMapper.addClass(clazz);
        return result;
    }

    @Override
    public int updateClass(Clazz clazz) {
        int result = classMapper.updateClass(clazz);
        return result;
    }

    @Override
    public int deleteClass(Integer class_id) {
        int result = classMapper.deleteClass(class_id);
        return result;
    }

}
