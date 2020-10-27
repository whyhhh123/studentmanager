package com.why.studentmanager.domain;

import java.util.Objects;

public class Clazz {
    private int class_id;
    private String class_name;
    private String info;
    private String teacher_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }



    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return class_id == clazz.class_id &&
                Objects.equals(class_name, clazz.class_name) &&
                Objects.equals(info, clazz.info) &&
                Objects.equals(teacher_name, clazz.teacher_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(class_id, class_name, info, teacher_name);
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", info='" + info + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                '}';
    }
}
