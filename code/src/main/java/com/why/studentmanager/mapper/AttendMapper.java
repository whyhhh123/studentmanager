package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;

import java.util.List;

public interface AttendMapper {
    List<Attend> findByCourseId(int courseId);
    List<Attend> findByTid(int tid);
    int newattend(Attend attend);
    int updateNum(int id);
    int batchInsert(List<Attendance> attendances);
    int countselect(int courseId);
    Attend findById(int id);
    int findByAttend(Attend attend);
}
