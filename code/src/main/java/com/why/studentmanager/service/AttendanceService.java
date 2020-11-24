package com.why.studentmanager.service;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> findByCourseId(int courseId);
    List<Attendance> findBySid(int sid);
    List<Attendance> findAll();
    int addAttend(Attendance attendance);
    List<Attendance> findByAttend(Attendance attendance);
    int attendOnTime(int id);
    List<Attendance> findByCourseIdAttend(Attend attend);
}
