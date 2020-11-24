package com.why.studentmanager.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.why.studentmanager.domain.UploadEasyExcelData;
import com.why.studentmanager.service.UploadEasyExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EasyExcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelController.class);

    @Autowired
    private UploadEasyExcelService uploadEasyExcelService;

    @GetMapping(value="/downloadEasyExcel",produces="application/josn;charset=UTF-8")
    public void downloadEasyExcel(HttpServletResponse response) throws Exception{

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String datetime = sdf.format(new Date());
        String fileName = URLEncoder.encode("成绩表","UTF-8")+datetime;

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        // excel头策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 11);
        headWriteFont.setBold(false);
        headWriteCellStyle.setWriteFont(headWriteFont);

        // excel内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short)11);
        contentWriteCellStyle.setWriteFont(contentWriteFont);

        // 设置handler
        HorizontalCellStyleStrategy styleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        List<UploadEasyExcelData> uploadEasyExcelData = uploadEasyExcelService.selectALL();

        EasyExcel.write(response.getOutputStream(), UploadEasyExcelData.class)
                .sheet("成绩表")
                .registerWriteHandler(styleStrategy)
                .doWrite(uploadEasyExcelData);

    }

    @GetMapping(value="/downloadTemplate",produces="application/josn;charset=UTF-8")
    public void downloadTemplate(HttpServletResponse response,int courseId) throws Exception{
        System.out.println(courseId);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String datetime = sdf.format(new Date());
        String fileName = URLEncoder.encode("成绩表","UTF-8")+datetime;

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        // excel头策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 11);
        headWriteFont.setBold(false);
        headWriteCellStyle.setWriteFont(headWriteFont);

        // excel内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short)11);
        contentWriteCellStyle.setWriteFont(contentWriteFont);

        // 设置handler
        HorizontalCellStyleStrategy styleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        List<UploadEasyExcelData> uploadEasyExcelData = uploadEasyExcelService.findByCoorseId(courseId);

        EasyExcel.write(response.getOutputStream(), UploadEasyExcelData.class)
                .sheet("成绩表")
                .registerWriteHandler(styleStrategy)
                .doWrite(uploadEasyExcelData);



    }


    @PostMapping(value = "/upload")
    public void uploadEasyExcl(HttpServletRequest request, @RequestParam(value = "file",required = false)MultipartFile file) throws IOException {

        System.out.println(" file = " + file);
        Map<String ,Object> result = new HashMap<>();
        uploadEasyExcelService.saveUser(file);

    }

    @GetMapping("/student/saveimg")
    @ResponseBody
    public String test(){
        return "index/score/TEST";
    }

}
