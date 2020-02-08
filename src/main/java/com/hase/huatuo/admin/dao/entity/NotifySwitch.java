package com.hase.huatuo.admin.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
@ApiModel(description = "Notify Switch")
@Data
public class NotifySwitch {

    @Id
    @Column(name = "app_id")
    private String appId;

    @Column(name = "sms_enable")
    private String smsEnable;

    @Column(name = "mail_enable")
    private String mailEnable;

    @Column(name = "wechat_push")
    private String wechatPushEnable;

    @Column(name = "enable")
    private String enable;

}
