package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Leave;

import java.util.List;

public interface LeaveMapper {
    int addLeave(Leave leave);
    int deleteById(int id);
    Leave findById(int id);
    int updateLeave(Leave leave);
    List<Leave> findAllLeave();
    int alterTable();
}
