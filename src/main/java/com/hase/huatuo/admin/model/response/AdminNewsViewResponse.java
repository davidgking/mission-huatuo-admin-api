package com.hase.huatuo.admin.model.response;

import com.hase.huatuo.admin.dao.entity.NewsInfo;
import lombok.Data;

import java.util.List;

@Data
public class AdminNewsViewResponse extends AdminResponse {

    private List<NewsInfo> items;

    private Integer total;
}
