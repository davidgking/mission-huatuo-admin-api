package com.hase.huatuo.admin.dao;

import com.hase.huatuo.admin.dao.entity.Notify;
import com.hase.huatuo.admin.dao.view.NotifyStaffView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyStaffListRepository extends JpaRepository<Notify,String> {

    @Query("SELECT new com.hase.huatuo.admin.dao.view.NotifyStaffView(n,s) from" +
            " Notify n , com.hase.huatuo.admin.dao.entity.StaffList s " +
            " where n.staffId = s.staffId ")
    List<NotifyStaffView> findAllStaff();

}
