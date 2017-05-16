package com.yuncang.entity;


/**
 * Created by lzw on 2017/5/11.
 * 供货商实体
 */
public class ProfferBill {
    private String profferedId;
    private String profferedName;
    private String contactPerson;
    private String contactPhone;
    private String remarks;

    public String getProfferedId() {
        return profferedId;
    }

    public void setProfferedId(String profferedId) {
        this.profferedId = profferedId;
    }

    public String getProfferedName() {
        return profferedName;
    }

    public void setProfferedName(String profferedName) {
        this.profferedName = profferedName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ProfferBill{" +
                "profferedId='" + profferedId + '\'' +
                ", profferedName='" + profferedName + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
