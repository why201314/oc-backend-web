package jp.co.intellisea.oc.web.sales.entity;

import java.util.Date;

public class MonthlyWorkInfo {
    private Integer monthlyWorkInfoId;

    private Integer employeeId;

    private Date date;

    private String filePath;

    private Date note;

    public Integer getMonthlyWorkInfoId() {
        return monthlyWorkInfoId;
    }

    public void setMonthlyWorkInfoId(Integer monthlyWorkInfoId) {
        this.monthlyWorkInfoId = monthlyWorkInfoId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getNote() {
        return note;
    }

    public void setNote(Date note) {
        this.note = note;
    }
}