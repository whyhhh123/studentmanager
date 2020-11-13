package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.mapper.CourseMapper;
import com.why.studentmanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    public int addCourse(Course course) {
        int result = courseMapper.addCourse(course);
        return result;
    }

    @Override
    public int updateCourse(Course course) {
        int result = courseMapper.updateCourse(course);
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteCourse(int id) {
        int result = courseMapper.deleteCourse(id);
        courseMapper.alterTable();
        return result;
    }

    @Override
    public Course findById(int id) {

        Course course = courseMapper.findById(id);
        return course;
    }
}
