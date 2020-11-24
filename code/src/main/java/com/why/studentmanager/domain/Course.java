package com.why.studentmanager.domain;

import java.util.Objects;

public class Course {
    private Integer id;
    private String name;
    private int tid;
    private String teacherName;
    private String courseDate;
    private int residueNum;
    private int maxNum;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                ", teacherName='" + teacherName + '\'' +
                ", courseDate='" + courseDate + '\'' +
                ", residueNum=" + residueNum +
                ", maxNum=" + maxNum +
                ", info='" + info + '\'' +
                ", attendNum=" + attendNum +
                '}';
    }

    public int getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(int attendNum) {
        this.attendNum = attendNum;
    }

    private String info;
    private int attendNum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return tid == course.tid &&
                residueNum == course.residueNum &&
                maxNum == course.maxNum &&
                Objects.equals(id, course.id) &&
                Objects.equals(name, course.name) &&
                Objects.equals(teacherName, course.teacherName) &&
                Objects.equals(courseDate, course.courseDate) &&
                Objects.equals(info, course.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tid, teacherName, courseDate, residueNum, maxNum, info);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public int getResidueNum() {
        return residueNum;
    }

    public void setResidueNum(int residueNum) {
        this.residueNum = residueNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
