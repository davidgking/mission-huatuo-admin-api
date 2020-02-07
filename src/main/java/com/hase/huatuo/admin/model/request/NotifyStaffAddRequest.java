package com.hase.huatuo.admin.model.request;

import lombok.Data;


@Data
public class NotifyStaffAddRequest {

    private String staffId;

    private String name;

    private String team;

    private String mobileNum;

    private String emailAddress;

    private String status;

    private String enable;

    private String appId;

    private String smsEnable;

    private String mailEnable;

    private String wechatPushEnable;
}
