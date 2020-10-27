package com.why.studentmanager.domain;

import java.util.Objects;

public class Student {
    private Integer id;
    private int sid;
    private String username;
    private String password;
    private int class_id;
    private String sex;
    private String mobile;
    private String class_name;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                class_id == student.class_id &&
                Objects.equals(id, student.id) &&
                Objects.equals(username, student.username) &&
                Objects.equals(password, student.password) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(mobile, student.mobile) &&
                Objects.equals(class_name, student.class_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid, username, password, class_id, sex, mobile, class_name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid=" + sid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", class_id=" + class_id +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
