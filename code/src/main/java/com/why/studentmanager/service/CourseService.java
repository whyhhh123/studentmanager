package com.why.studentmanager.service;

import com.why.studentmanager.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    int addCourse(Course course);
    int updateCourse(Course course);
    int deleteCourse(int id);
    Course findById(int id);
}
