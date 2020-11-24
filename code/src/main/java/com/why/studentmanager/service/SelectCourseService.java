package com.why.studentmanager.service;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;
import com.why.studentmanager.domain.Course;
import com.why.studentmanager.domain.SelectCourse;

import java.util.List;

public interface SelectCourseService {
    int addSelectCourse(SelectCourse selectCourse);
    List<Course> showSelected(int sid);
    int deleteBySelectCourse(SelectCourse selectCourse);
    SelectCourse findSelect(SelectCourse selectCourse);



}
