package com.hase.huatuo.admin.rest;

import com.hase.huatuo.admin.dao.entity.NewsInfo;
import com.hase.huatuo.admin.dao.entity.UserInfo;
import com.hase.huatuo.admin.dao.view.NotifyStaffView;
import com.hase.huatuo.admin.dao.entity.VpnInfo;
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
    public ResponseEntity<VpnReportViewResponse> queryVPNReport(@RequestParam Map<String,Object> map) {
        List<VpnInfo> vpnInfoList = huatuoAdminService.queryVPNReport(map);
        VpnReportViewResponse response = new VpnReportViewResponse();
        response.setItems(vpnInfoList);
        response.setTotal(vpnInfoList.size());
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
    public ResponseEntity<AdminNewsViewResponse> findNews(@RequestParam Map<String,Object> map) {
        List<NewsInfo> newsByParms = huatuoAdminService.findNewsByParms(map);
        AdminNewsViewResponse adminResponse = new AdminNewsViewResponse();
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
    public ResponseEntity<AdminUserInfoResponse> findAllUser(@RequestParam Map<String,Object> map) {
        List<UserInfo> newsByParms = huatuoAdminService.findAllUser();
        AdminUserInfoResponse adminResponse = new AdminUserInfoResponse();
        adminResponse.setItems(newsByParms);
        adminResponse.setTotal(newsByParms.size());
        adminResponse.setCode(20000);
        return ResponseEntity.ok(adminResponse);
    }

}
