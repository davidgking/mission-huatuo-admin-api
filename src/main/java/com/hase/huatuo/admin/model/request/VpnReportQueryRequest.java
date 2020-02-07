package com.hase.huatuo.admin.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "the requestBody that Conditional query VPN state report")
public class VpnReportQueryRequest {
    private Integer staffId;
    private String location;
    private String internetISP;
    private String lastUpatetime;
}
