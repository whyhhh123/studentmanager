package com.why.studentmanager.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class UploadEasyExcelData {

    @ExcelProperty(value="学号",index = 0)
    private int sid;

    @ExcelProperty(value="姓名",index = 1)
    private String sName;

    @ExcelProperty(value="班级名",index = 2)
    private String className;

    @ExcelProperty(value="课程名",index = 3)
    private String courseName;

    @ExcelProperty(value="成绩",index = 4)
    private double score;

    @ExcelProperty(value="备注",index = 5)
    private String remark;

    public UploadEasyExcelData() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
