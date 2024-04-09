package jp.co.intellisea.oc.web.sales.entity;

import java.util.Date;

public class Meeting {
    private Integer meetingId;

    private Date meetingDate;

    private Integer contactId;

    private String content;

    private String status;

    private Integer employeesId;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Integer employeesId) {
        this.employeesId = employeesId;
    }
}