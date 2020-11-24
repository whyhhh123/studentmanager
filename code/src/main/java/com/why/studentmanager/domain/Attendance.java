package com.why.studentmanager.domain;

import java.util.Date;

public class Attendance {
    private int id;
    private int courseId;
    private int sid;
    private String sName;
    private String courseName;
    private String time;
    private int attendId;
    private int status;
    public int getAttendId() {
        return attendId;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", sid=" + sid +
                ", sName='" + sName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", time='" + time + '\'' +
                ", attendId=" + attendId +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAttendId(int attendId) {
        this.attendId = attendId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
