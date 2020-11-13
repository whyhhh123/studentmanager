package com.why.studentmanager.domain;

public class SelectCourse {
    private Integer id;
    private Integer sid;
    private Integer courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "SelectCourse{" +
                "id=" + id +
                ", sid=" + sid +
                ", courseId=" + courseId +
                '}';
    }
}
