package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Leave;
import com.why.studentmanager.mapper.LeaveMapper;
import com.why.studentmanager.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    public LeaveMapper leaveMapper;

    @Override
    public int addLeave(Leave leave) {
        int result = leaveMapper.addLeave(leave);
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int deleteById(int id) {
        int result = leaveMapper.deleteById(id);
        leaveMapper.alterTable();
        return result;
    }

    @Override
    public Leave findById(int id) {
        Leave leave = leaveMapper.findById(id);
        return leave;
    }

    @Override
    public int updateLeave(Leave leave) {
        int result = leaveMapper.updateLeave(leave);
        return result;
    }

    @Override
    public List<Leave> findAllLeave() {
        List<Leave> leaves = leaveMapper.findAllLeave();
        return leaves;
    }

    @Override
    public List<Leave> findBySid(int sid) {
        List<Leave> leaves = leaveMapper.findBySid(sid);
        return leaves;
    }
}
