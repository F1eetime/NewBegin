package com.qt.springboot.pojo;

public class UserInfo {

    private String tel;
    private Integer id;
    private String pwd;
    private String user_id;
    private String nickName;

    @Override
    public String toString() {
        return "UserInfo{" +
                "tel='" + tel + '\'' +
                ", id=" + id +
                ", pwd='" + pwd + '\'' +
                ", user_id='" + user_id + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
