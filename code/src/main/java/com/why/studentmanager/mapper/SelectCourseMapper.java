package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.SelectCourse;

public interface SelectCourseMapper {
    int addSelectCourse(SelectCourse selectCourse);
    int deleteSelect(int id);
    int alterTable();

}
