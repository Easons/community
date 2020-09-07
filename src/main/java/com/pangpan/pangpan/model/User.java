package com.pangpan.pangpan.model;

/**
 * 数据库中的实体是model，这是和网络传输中的dto的区别
 */
public class User {

    private Integer id;
    private String name;
    private String accountId;
    private  String token;
    private Long gmtCreate;
    private Long gmtModefied;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModefied() {
        return gmtModefied;
    }

    public void setGmtModefied(Long gmtModefied) {
        this.gmtModefied = gmtModefied;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accoundId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModefied=" + gmtModefied +
                '}';
    }


}
