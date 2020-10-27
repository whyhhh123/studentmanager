package com.why.studentmanager.domain;

public class Clazz {
    private int class_id;
    private String name;
    private String info;

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "class_id=" + class_id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
