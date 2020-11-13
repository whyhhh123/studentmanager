package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;

import java.util.List;

public interface SelectCourseMapper {
    int addSelectCourse(SelectCourse selectCourse);
    int deleteById(int id);
    SelectCourse findSelect(SelectCourse selectCourse);
    SelectCourse findById(int id);
    int alterTable();
    List<Course> showSelected(int sid);

}
