package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;

import java.util.List;

public interface AttendanceMapper {
    List<Attendance> findByCourseId(int courseId);
    List<Attendance> findBySid(int sid);
    List<Attendance> findAll();
    List<Attendance> findByAttend(Attendance attendance);
    int addAttend(Attendance attendance);
    Attendance findById(int id);
    int updateStatus(Attendance attendance);
    List<Attendance> findByCourseIdAttend(Attend attend);

}
