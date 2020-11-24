package com.why.studentmanager.service;

import com.why.studentmanager.domain.Attend;
import com.why.studentmanager.domain.Attendance;

import java.util.List;

public interface AttendService {
    List<Attend> findByCourseId(int courseId);
    List<Attend> findByTid(int tid);
    int newattend(Attend attend);
    int updateNum(int id);
    int batchInsert(List<Attendance> attendances);
    int findByAttend(Attend attend);
}
