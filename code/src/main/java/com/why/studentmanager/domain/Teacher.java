package com.why.studentmanager.domain;

import java.util.Objects;

public class Teacher {
    private Integer id;
    private int tid;
    private String username;
    private String password;
    private int class_id;
    private String sex;
    private String mobile;
    private String class_name;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid=" + tid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", class_id=" + class_id +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return tid == teacher.tid &&
                class_id == teacher.class_id &&
                Objects.equals(id, teacher.id) &&
                Objects.equals(username, teacher.username) &&
                Objects.equals(password, teacher.password) &&
                Objects.equals(sex, teacher.sex) &&
                Objects.equals(mobile, teacher.mobile) &&
                Objects.equals(class_name, teacher.class_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tid, username, password, class_id, sex, mobile, class_name);
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
}
