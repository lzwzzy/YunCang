package com.yuncang.entity;


/**
 * Created by lzw on 2017/5/11.
 * 供货商实体
 */
public class ProfferBill {
    private boolean checked;
    private String profferedId;
    private String profferedName;
    private String mainBusiness;
    private String contactPerson;
    private String contactPhone;
    private String profferedFax;
    private String profferedAddress;
    private String remarks;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getProfferedFax() {
        return profferedFax;
    }

    public void setProfferedFax(String profferedFax) {
        this.profferedFax = profferedFax;
    }

    public String getProfferedAddress() {
        return profferedAddress;
    }

    public void setProfferedAddress(String profferedAddress) {
        this.profferedAddress = profferedAddress;
    }

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
                ", mainBusiness='" + mainBusiness + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", profferedFax='" + profferedFax + '\'' +
                ", profferedAddress='" + profferedAddress + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
