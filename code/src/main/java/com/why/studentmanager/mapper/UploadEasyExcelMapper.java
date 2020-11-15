package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.UploadEasyExcelData;

import java.util.List;

public interface UploadEasyExcelMapper {
    List<UploadEasyExcelData> selectAll();
}
