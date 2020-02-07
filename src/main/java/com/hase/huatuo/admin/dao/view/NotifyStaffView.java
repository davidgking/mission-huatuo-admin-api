package com.hase.huatuo.admin.dao.view;

import com.hase.huatuo.admin.dao.entity.Notify;
import com.hase.huatuo.admin.dao.entity.StaffList;
import lombok.Data;

@Data
public class NotifyStaffView {

    private Notify notify;
    private StaffList staffList;

    public NotifyStaffView(Notify notify, StaffList staffList) {
        this.notify = notify;
        this.staffList = staffList;
    }
}
