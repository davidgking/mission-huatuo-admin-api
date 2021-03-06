package com.hase.huatuo.admin.service;

import com.hase.huatuo.admin.dao.*;
import com.hase.huatuo.admin.dao.entity.*;
import com.hase.huatuo.admin.dao.view.NotifyStaffView;
import com.hase.huatuo.admin.model.request.NotifyStaffAddRequest;
import com.hase.huatuo.admin.model.request.VpnReportQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class HuatuoAdminService {

	@Autowired
	private VPNInfoRepository vpnInfoRepository;

	@Autowired
	private NewsInfoRepository newsInfoRepository;

	@Autowired
	private NotifyStaffListRepository notifyStaffListRepository;

	@Autowired
	private NotifyRepository notifyRepository;

	@Autowired
	private StaffListRepository staffListRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private NotifySwitchRepository notifySwitchRepository;

	@Autowired
	private HealthInfoHACNRepository healthInfoHACNRepository;

	/**
	 * Query Vpn Info
	 * @param map
	 * @return
	 */
	public List<VpnInfo> queryVPNReport(Map<String,Object> map) {
		Object staffId = map.get("staffId");
		Object location = map.get("location");
		Object internetISP = map.get("internetISP");
		Object lastUpatetime = map.get("lastUpatetime");
		Object appId = map.get("appId");
		VpnReportQueryRequest vpnReportQueryRequest = new VpnReportQueryRequest();
		if (staffId != null && !"".equals(staffId)) {
			vpnReportQueryRequest.setStaffId(Integer.parseInt(String.valueOf(staffId)));
		}
		if (location != null && !"".equals(location)) {
			vpnReportQueryRequest.setLocation("%"+String.valueOf(location)+"%");
		}
		if (internetISP != null && !"".equals(internetISP)) {
			vpnReportQueryRequest.setInternetISP(String.valueOf(internetISP));
		}
		if (lastUpatetime != null && !"".equals(lastUpatetime)) {
			vpnReportQueryRequest.setLastUpatetime(String.valueOf(lastUpatetime+"%"));
		}

		List<VpnInfo> vpnInfos = vpnInfoRepository.vpnReportView(vpnReportQueryRequest.getStaffId()
				, vpnReportQueryRequest.getLocation(),
				vpnReportQueryRequest.getInternetISP(),
				vpnReportQueryRequest.getLastUpatetime(),
				String.valueOf(appId));
		return vpnInfos;
	}

	/**
	 * Query Notify Staff
	 * @return
	 */
	public Page<NotifyStaffView> findNotifyStaff(Map<String, Object> map) {
		Integer page = Integer.parseInt(String.valueOf(map.get("page")));
		Integer limit = Integer.parseInt(String.valueOf(map.get("limit")));
		String appId = String.valueOf(map.get("appId"));
		if(page <=0){
			page = 1;
		}
		Sort sort=new Sort(Sort.Direction.ASC,"staffId");
		Pageable pageable = new PageRequest(page-1,limit,sort);
		return notifyStaffListRepository.findAllStaff(appId,pageable);
	}

	/**
	 * Save Notify Staff
     * @param notifyStaffAddRequest
     */
	@Transactional
	public void saveNotifyStaff(NotifyStaffAddRequest notifyStaffAddRequest) {
		Notify notify = new Notify();
		notify.setStaffId(notifyStaffAddRequest.getStaffId());
		notify.setStatus(notifyStaffAddRequest.getStatus());
		notify.setAppId(notifyStaffAddRequest.getAppId());
		notify.setEnable(notifyStaffAddRequest.getEnable());
		notify.setMailEnable(notifyStaffAddRequest.getMailEnable());
		notify.setSmsEnable(notifyStaffAddRequest.getSmsEnable());
		notify.setWechatPushEnable(notifyStaffAddRequest.getWechatPushEnable());
		notifyRepository.save(notify);

//		StaffList staffList = new StaffList();
//		staffList.setStaffId(notifyStaffAddRequest.getStaffId());
//		staffList.setEmailAddress(notifyStaffAddRequest.getEmailAddress());
//		staffList.setMobileNum(notifyStaffAddRequest.getMobileNum());
//		staffListRepository.save(staffList);
	}

	/**
	 * Delete Notify Staff
	 * @param staffId
	 */
	@Transactional
	public void deleteNotifyStaff(String staffId) {
		notifyRepository.deleteById(staffId);
	}

	/**
	 * query all news
	 * @param map
	 * @return
	 */
	public List<NewsInfo> findNewsByParms(Map<String,Object> map) {
		Object appId = map.get("appId");
		return newsInfoRepository.findAllByAppId(String.valueOf(appId));
	}

	/**
	 * Save news
	 * @param newsInfo
	 */
	public void saveNews(NewsInfo newsInfo) {
		newsInfoRepository.save(newsInfo);
	}

	/**
	 * Delete news
	 * @param id
	 */
	@Transactional
	public void deleteNews(String id) {
		newsInfoRepository.deleteById(Long.parseLong(id));
	}


	public List<UserInfo> findAllUser(Map<String,Object> map) {
		Object appId = map.get("appId");
		Object staffId = map.get("staffId");
		if (staffId != null && !"".equals(String.valueOf(staffId).trim())) {
			return userInfoRepository.findAllByAppIdAndStaffId(String.valueOf(appId),String.valueOf(staffId));
		} else {
			return userInfoRepository.findAllByAppId(String.valueOf(appId));
		}
	}

	@Transactional
	public void deleteUserInfo(String appId,String staffId) {
		userInfoRepository.deleteByAppIdAndStaffId(appId,staffId);
	}

	public StaffList getStaff(String staffId) {
		return staffListRepository.getByStaffId(staffId);
	}

	public void deleteNotifySwitch(String appId) {
		notifySwitchRepository.deleteById(appId);
	}

	public List<NotifySwitch> findAllNotifySwitch(Map<String, Object> map) {
		Object appId = map.get("appId");
		return notifySwitchRepository.findAllByAppId(String.valueOf(appId));
	}

	public void saveNotifySwitch(NotifySwitch notifySwitch) {
		notifySwitchRepository.save(notifySwitch);
	}

    public List<HealthInfoHACN> queryHealthHacn(Map<String,Object> map) {
		Object staffId = map.get("staffId");
		Object staffName = map.get("staffName");
		Object reportDate = map.get("reportDate");
		Object healthStatus = map.get("healthStatus");
		Object cityName = map.get("cityName");
		String p1 = null;
		if (staffId != null && !"".equals(String.valueOf(staffId).trim())){
			p1 = String.valueOf(staffId);
		}
		String p2 = null;
		if (staffName != null && !"".equals(String.valueOf(staffName).trim())){
			p2 = "%"+String.valueOf(staffName)+"%";
		}
		String p3 = null;
		if (reportDate != null && !"".equals(String.valueOf(reportDate).trim())){
			p3 = String.valueOf(reportDate)+"%";
		}
		String p4 = null;
		if (healthStatus != null && !"".equals(String.valueOf(healthStatus).trim())){
			p4 = String.valueOf(healthStatus);
		}
		String p5 = null;
		if (cityName != null && !"".equals(String.valueOf(cityName).trim())){
			p5 = String.valueOf(cityName);
		}
		return healthInfoHACNRepository.findAll(p1,p2,p3,p4,p5);
    }
}
