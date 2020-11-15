package com.why.studentmanager.service.impl;

import com.why.studentmanager.domain.UploadEasyExcelData;
import com.why.studentmanager.mapper.UploadEasyExcelMapper;
import com.why.studentmanager.service.UploadEasyExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadEasyExcelServiceImpl implements UploadEasyExcelService {
    @Autowired
    private UploadEasyExcelMapper uploadEasyExcelMapper;

    @Override
    public List<UploadEasyExcelData> selectALL() {

        return uploadEasyExcelMapper.selectAll();
    }
}
