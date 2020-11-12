package com.why.studentmanager.domain;

public class SelectCourse {
    private Integer id;
    private Integer sId;

    @Override
    public String toString() {
        return "SelectCourse{" +
                "id=" + id +
                ", sId=" + sId +
                ", courseId=" + courseId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    private Integer courseId;
}
