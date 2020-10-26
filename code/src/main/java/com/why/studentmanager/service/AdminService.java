package com.why.studentmanager.service;

import com.why.studentmanager.domain.Admin;

public interface AdminService {
    Admin findByAdmin(Admin admin);
    int updatePwdByAdmin(Admin admin);
}
