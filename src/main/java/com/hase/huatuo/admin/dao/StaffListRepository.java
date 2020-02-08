package com.hase.huatuo.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hase.huatuo.admin.dao.entity.StaffList;

@Repository
public interface StaffListRepository extends JpaRepository<StaffList,String> {

    StaffList getByStaffId(String staffId);

}
