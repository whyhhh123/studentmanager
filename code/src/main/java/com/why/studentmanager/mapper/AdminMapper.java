package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Admin;

public interface AdminMapper {

    Admin findByAdmin(Admin admin);

    int updatePwdByAdmin(Admin admin);

}
