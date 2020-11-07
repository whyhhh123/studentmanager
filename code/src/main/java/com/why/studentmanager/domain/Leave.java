package com.why.studentmanager.domain;

public class Leave {
    private Integer id;
    private Integer sid;
    private String sName;
    private String info;
    private int status;
    private String remark;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", sid=" + sid +
                ", sName='" + sName + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
