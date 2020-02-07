package com.hase.huatuo.admin.model.response;

import com.hase.huatuo.admin.dao.entity.NewsInfo;
import com.hase.huatuo.admin.dao.entity.UserInfo;
import lombok.Data;

import java.util.List;

@Data
public class AdminUserInfoResponse extends AdminResponse {

    private List<UserInfo> items;

    private Integer total;
}
