package com.hase.huatuo.admin.dao;

import com.hase.huatuo.admin.dao.entity.NotifySwitch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifySwitchRepository extends JpaRepository<NotifySwitch,String> {

    List<NotifySwitch> findAllByAppId(String appId);
}
