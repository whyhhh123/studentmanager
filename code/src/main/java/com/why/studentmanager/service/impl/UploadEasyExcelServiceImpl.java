package com.why.studentmanager.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.why.studentmanager.domain.Score;
import com.why.studentmanager.domain.UploadEasyExcelData;
import com.why.studentmanager.mapper.ScoreMapper;
import com.why.studentmanager.mapper.UploadEasyExcelMapper;
import com.why.studentmanager.service.UploadEasyExcelService;
import com.why.studentmanager.until.DemoDataListener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UploadEasyExcelServiceImpl implements UploadEasyExcelService {
    @Autowired
    private UploadEasyExcelMapper uploadEasyExcelMapper;

    @Override
    public List<UploadEasyExcelData> selectALL() {

        return uploadEasyExcelMapper.selectAll();
    }

    @Override
    public List<UploadEasyExcelData> findByCoorseId(int courseId) {
        List<UploadEasyExcelData> uploadEasyExcelData = uploadEasyExcelMapper.findByCourseId(courseId);
        return uploadEasyExcelData;
    }

    @Override
    public void saveUser(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        /* if(!file.getOriginalFilename().equals("上传测试.xls") && !file.getOriginalFilename().equals("上传测试.xlsx") ){
            return;
        }*/
        InputStream inputStream = new BufferedInputStream(file.getInputStream());
        //实例化实现了AnalysisEventListener接口的类
        DemoDataListener excelListener = new DemoDataListener(uploadEasyExcelMapper);
        ExcelReader reader = new ExcelReader(inputStream,null,excelListener);
        //读取信息
        reader.read(new Sheet(1,1, UploadEasyExcelData.class));
    }

}
