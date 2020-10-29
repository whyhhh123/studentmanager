package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.Admin;
import com.why.studentmanager.mapper.AdminMapper;
import com.why.studentmanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByAdmin(Admin admin) {

        Admin admin1 = adminMapper.findByAdmin(admin);

        return admin1;
    }

    @Override
    public int updatePwdByAdmin(Admin admin) {
        int result = adminMapper.updatePwdByAdmin(admin);
        return result;
    }
}
