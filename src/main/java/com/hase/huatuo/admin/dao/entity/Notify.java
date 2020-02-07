package com.hase.huatuo.admin.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
@ApiModel(description = "Notify staff")
@Data
public class Notify {
    @Id
    @Column(name = "staff_id", nullable = false)
    @ApiModelProperty(value = "45022339", notes = "staff id", dataType = "java.lang.String")
    private String staffId;

    @Column(name = "status", nullable = false)
    @ApiModelProperty(value = "0", notes = "status", dataType = "java.lang.String")
    private String status;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "sms_enable")
    private String smsEnable;

    @Column(name = "mail_enable")
    private String mailEnable;

    @Column(name = "wechat_push_enable")
    private String wechatPushEnable;

    @Column(name = "enable")
    private String enable;

}
