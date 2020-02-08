package com.hase.huatuo.admin.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity()
@IdClass(VpnInfo.VpnInfoKey.class)
@ApiModel(description = "DO of VPN state info")
@Data
public class VpnInfo {
    @Id
    @Column(name = "staff_id", nullable = false)
    @ApiModelProperty(value = "45022339", notes = "staff id of VPN state", dataType = "java.lang.String")
    private String staffId;
    @Id
    @Column(name = "vpn_type", nullable = false)
    @ApiModelProperty(value = "0", notes = "VPN type", dataType = "java.lang.String")
    private String vpnType;
    @Column(name = "open_id")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String openId;
    @Column(name = "location")
    @ApiModelProperty(value = "0", notes = "location", dataType = "java.lang.String")
    private String location;
    @Column(name = "isp")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String isp;
    @Column(name = "link_Type")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String linkType;
    @Column(name = "band_width")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String bandWidth;
    @Column(name = "had_reboot_adsl")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String hadRebootADSL;
    @Column(name = "symptom")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String symptom;
    @Column(name = "outlook_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String outlookSlow;
    @Column(name = "jabber_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String jabberSlow;
    @Column(name = "sametime_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String sametimeSlow;
    @Column(name = "video_conference_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String videoConferenceSlow;
    @Column(name = "sharepoint_shared_folder_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String sharepointSharedFolderSlow;
    @Column(name = "has_other_applications_slow")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String hasOtherApplicationsSlow;
    @Column(name = "other_slow_applications")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String otherSlowApplications;
    @Column(name = "has_some_applications_cannot_access")
    @ApiModelProperty(value = "0", notes = "Open id", dataType = "java.lang.String")
    private String hasSomeApplicationsCannotAccess;
    @Column(name = "cannot_access_applications")
    @ApiModelProperty(name = "name test", value = "0", notes = "Open id", dataType = "java.lang.String")
    private String cannotAccessApplications;
    @Column(name = "reporter_staff_id")
    @ApiModelProperty(value = "45022339", notes = "state reporter staff id", dataType = "java.lang.String")
    private String reporterStaffId;
    @Column(name = "last_update_datetime")
    private Date lastUpdateDatetime;
    @Column(name = "app_id")
    private String appId;


    public static class VpnInfoKey implements Serializable {

        private String staffId;

        private String vpnType;

        public String getStaffId() {
            return staffId;
        }

        public void setStaffId(String staffId) {
            this.staffId = staffId;
        }

        public String getVpnType() {
            return vpnType;
        }

        public void setVpnType(String vpnType) {
            this.vpnType = vpnType;
        }
    }
}
