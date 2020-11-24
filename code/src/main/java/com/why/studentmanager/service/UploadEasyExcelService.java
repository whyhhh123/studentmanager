package com.why.studentmanager.service;

import com.why.studentmanager.domain.UploadEasyExcelData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadEasyExcelService {
    List<UploadEasyExcelData> selectALL();
    List<UploadEasyExcelData> findByCoorseId(int courseId);
    void saveUser(MultipartFile file)throws IOException;
}
