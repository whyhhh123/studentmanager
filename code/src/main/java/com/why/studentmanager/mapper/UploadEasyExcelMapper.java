package com.why.studentmanager.mapper;

import com.why.studentmanager.domain.Score;
import com.why.studentmanager.domain.UploadEasyExcelData;

import java.util.List;

public interface UploadEasyExcelMapper {
    List<UploadEasyExcelData> selectAll();
    List<UploadEasyExcelData> findByCourseId(int courseId);

    int batchInsert(List<UploadEasyExcelData> scores);

}
