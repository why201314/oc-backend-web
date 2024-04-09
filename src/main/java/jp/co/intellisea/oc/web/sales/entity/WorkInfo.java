package jp.co.intellisea.oc.web.sales.entity;

import java.util.Date;

public class WorkInfo {
    private Integer workInfoId;

    private Integer employeeId;

    private Date startTime;

    private Date endTime;

    private String append;

    private String note;

    public Integer getWorkInfoId() {
        return workInfoId;
    }

    public void setWorkInfoId(Integer workInfoId) {
        this.workInfoId = workInfoId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}