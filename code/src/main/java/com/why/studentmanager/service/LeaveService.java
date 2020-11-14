package com.why.studentmanager.service;

import com.why.studentmanager.domain.Leave;

import java.util.List;

public interface LeaveService {
    int addLeave(Leave leave);
    int deleteById(int id);
    Leave findById(int id);
    int updateLeave(Leave leave);
    List<Leave> findAllLeave();
    List<Leave> findBySid(int sid);
}
