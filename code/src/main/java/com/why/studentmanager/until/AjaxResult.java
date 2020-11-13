package com.why.studentmanager.until;

public class AjaxResult {
    private String msg;
    private boolean status;

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
