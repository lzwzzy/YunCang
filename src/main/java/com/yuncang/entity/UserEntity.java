package com.yuncang.entity;

/**
 * Created by lzw on 2017/4/22.
 * 用户实体
 */
public class UserEntity {
    private int userid;
    private String username;
    private String password;
    private long phone;
    private String sex;
    private String email;
    private String introduce;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
