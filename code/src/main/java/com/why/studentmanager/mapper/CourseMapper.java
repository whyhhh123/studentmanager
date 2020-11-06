
package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> findAllCourse();
    int updateCourse(Course course);
    int deleteCourse(int id);
    int addCourse(Course course);
    Course findById(int id);
}

