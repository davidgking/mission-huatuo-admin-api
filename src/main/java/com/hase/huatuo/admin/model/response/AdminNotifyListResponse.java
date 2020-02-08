package com.hase.huatuo.admin.model.response;

import com.hase.huatuo.admin.dao.view.NotifyStaffView;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class AdminNotifyListResponse  extends AdminResponse{
    private Page<NotifyStaffView> data;
}
