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

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EasyExcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelController.class);

    @Autowired
    private UploadEasyExcelService uploadEasyExcelService;

    @GetMapping(value="/downloadEasyExcel",produces="application/josn;charset=UTF-8")
    public void downloadEasyExcel(HttpServletResponse response) throws Exception{

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String datetime = sdf.format(new Date());
        String fileName = URLEncoder.encode("下载excel服务","UTF-8")+datetime;

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
                .sheet("下载excel服务")
                .registerWriteHandler(styleStrategy)
                .doWrite(uploadEasyExcelData);



    }

}
