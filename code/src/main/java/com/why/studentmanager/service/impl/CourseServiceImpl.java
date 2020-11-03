package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.mapper.CourseMapper;
import com.why.studentmanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAllCourse() {
        List<Course> courses = courseMapper.findAllCourse();
        return courses;
    }

    @Override
    public int updateCourse(Course course) {
        int result = courseMapper.updateCourse(course);
        return result;
    }

    @Override
    public int deleteCourse(int id) {
        int result = courseMapper.deleteCourse(id);
        return result;
    }
}
