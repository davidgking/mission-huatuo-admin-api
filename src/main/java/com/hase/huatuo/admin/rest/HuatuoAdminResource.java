package com.hase.huatuo.admin.rest;

import com.hase.huatuo.admin.dao.entity.*;
import com.hase.huatuo.admin.dao.view.NotifyStaffView;
import com.hase.huatuo.admin.model.request.NotifyStaffAddRequest;
import com.hase.huatuo.admin.model.response.*;
import com.hase.huatuo.admin.service.HuatuoAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping({"/huatuo-admin/api"})
public class HuatuoAdminResource {

    @Autowired
    private HuatuoAdminService huatuoAdminService;


    @GetMapping("/vpn/reportQuery")
    @ApiOperation(value = "vpnReportView", notes = "Index VPN status report", httpMethod = "GET")
    public ResponseEntity<AdminResponse> queryVPNReport(@RequestParam Map<String,Object> map) {
        List<VpnInfo> vpnInfoList = huatuoAdminService.queryVPNReport(map);
        AdminResponse response = new AdminResponse();
        response.setItems(vpnInfoList);
        response.setTotal(vpnInfoList.size());
        response.setCode(20000);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/healthHacn/fetchList")
    @ApiOperation(value = "healthHacn", notes = "query healthHacn", httpMethod = "GET")
    public ResponseEntity<AdminResponse> queryHealthHacn(@RequestParam Map<String,Object> map) {
        List<HealthInfoHACN> list = huatuoAdminService.queryHealthHacn(map);
        AdminResponse response = new AdminResponse();
        response.setItems(list);
        response.setTotal(list.size());
        response.setCode(20000);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/notify/fetchList")
    @ApiOperation(value = "notifyStaff", notes = "list for notify", httpMethod = "GET")
    public ResponseEntity<AdminNotifyListResponse> queryNotifyStaff(@RequestParam Map<String,Object> map) {
        Page<NotifyStaffView> viewList = huatuoAdminService.findNotifyStaff(map);
        AdminNotifyListResponse response = new AdminNotifyListResponse();
        response.setData(viewList);
//        response.setTotal(viewListiewList.size());
        response.setCode(20000);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/notify/save")
    @ApiOperation(value = "SaveNotifyStaff", notes = "save notify", httpMethod = "POST")
    public ResponseEntity<AdminResponse> saveNotifyStaff(@RequestBody NotifyStaffAddRequest notifyStaffAddRequest) {
        huatuoAdminService.saveNotifyStaff(notifyStaffAddRequest);
        AdminResponse response = new AdminResponse();
        response.setCode(20000);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/notify/delete/{staffId}")
    @ApiOperation(value = "delnotifyStaff", notes = "delete notify staff", httpMethod = "GET")
    public ResponseEntity<AdminResponse> queryNotifyStaff(@PathVariable String staffId) {
        huatuoAdminService.deleteNotifyStaff(staffId);
        AdminResponse response = new AdminResponse();
        response.setCode(20000);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/news/fecthList")
    @ApiOperation(value = "newsInfo", notes = "find all News", httpMethod = "GET")
    public ResponseEntity<AdminResponse> findNews(@RequestParam Map<String,Object> map) {
        List<NewsInfo> newsByParms = huatuoAdminService.findNewsByParms(map);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setItems(newsByParms);
        adminResponse.setTotal(newsByParms.size());
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @PostMapping("/news/save")
    @ApiOperation(value = "saveNews", notes = "save news", httpMethod = "POST")
    public ResponseEntity<AdminResponse> saveNews(@RequestBody NewsInfo newsInfo) {
        huatuoAdminService.saveNews(newsInfo);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/news/delete/{id}")
    @ApiOperation(value = "deleteNews", notes = "delete news", httpMethod = "GET")
    public ResponseEntity<AdminResponse> deleteNews(@PathVariable String id) {
        AdminResponse adminResponse = new AdminResponse();
        huatuoAdminService.deleteNews(id);
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/userInfo/delete/{appId}/{staffId}")
    @ApiOperation(value = "deleteUser", notes = "delete user", httpMethod = "GET")
    public ResponseEntity<AdminResponse> deleteUserInfo(@PathVariable String appId,
                                                        @PathVariable String staffId) {
        huatuoAdminService.deleteUserInfo(appId,staffId);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/userInfo/fecthList")
    @ApiOperation(value = "userInfoList", notes = "find all userInfo", httpMethod = "GET")
    public ResponseEntity<AdminResponse> findAllUser(@RequestParam Map<String,Object> map) {
        List<UserInfo> newsByParms = huatuoAdminService.findAllUser(map);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setItems(newsByParms);
        adminResponse.setTotal(newsByParms.size());
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/userInfo/getStaff/{staffId}")
    @ApiOperation(value = "getStaff", notes = "get MobileNum and Email", httpMethod = "GET")
    public ResponseEntity<AdminUserResponse> getStaff(@PathVariable String staffId) {
        AdminUserResponse adminResponse = new AdminUserResponse();
        StaffList staffList = huatuoAdminService.getStaff(staffId);
        if (staffList != null) {
            adminResponse.setStaffId(staffId);
            adminResponse.setMobileNum(staffList.getMobileNum());
            adminResponse.setEmailAddress(staffList.getEmailAddress());
        } else {
            adminResponse.setMessage("Staff Id不存在");
        }
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/notifySwitch/fecthList")
    @ApiOperation(value = "notifySwitchListy", notes = "find notifySwitch List", httpMethod = "GET")
    public ResponseEntity<AdminResponse> findNotifySwitch(@RequestParam Map<String,Object> map) {
        List<NotifySwitch> notifySwitchList = huatuoAdminService.findAllNotifySwitch(map);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setItems(notifySwitchList);
        adminResponse.setTotal(notifySwitchList.size());
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @PostMapping("/notifySwitch/save")
    @ApiOperation(value = "saveNotifySwitch", notes = "save notifySwitch", httpMethod = "POST")
    public ResponseEntity<AdminResponse> saveNotifySwitch(@RequestBody NotifySwitch notifySwitch) {
        huatuoAdminService.saveNotifySwitch(notifySwitch);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

    @GetMapping("/notifySwitch/delete/{appId}")
    @ApiOperation(value = "deleteNotifySwitch", notes = "delete NotifySwitch", httpMethod = "GET")
    public ResponseEntity<AdminResponse> deleteNotifySwitch(@PathVariable String appId) {
        AdminResponse adminResponse = new AdminResponse();
        huatuoAdminService.deleteNotifySwitch(appId);
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }
}
