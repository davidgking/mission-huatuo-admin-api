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
}
