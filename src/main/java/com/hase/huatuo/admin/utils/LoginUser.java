package com.hase.huatuo.admin.utils;


import lombok.Data;

@Data
public class LoginUser {

    private String loginId;

    private String password;

    private String appId;

    private String [] roles;

    public LoginUser(String loginId, String password, String appId) {
        this.loginId = loginId;
        this.password = password;
        this.appId = appId;
    }
}
