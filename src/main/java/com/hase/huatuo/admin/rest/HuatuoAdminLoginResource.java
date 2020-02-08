package com.hase.huatuo.admin.rest;


import com.hase.huatuo.admin.model.response.AdminLoginResponse;
import com.hase.huatuo.admin.model.response.AdminUserResponse;
import com.hase.huatuo.admin.utils.LoginConstant;
import com.hase.huatuo.admin.utils.LoginUser;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping({"/huatuo-admin/api","/api"})
@Slf4j
public class HuatuoAdminLoginResource {

    private final String TOKEN = "admin-token";

    @GetMapping("/user/login")
    @ApiOperation(value = "user", notes = "login user", httpMethod = "GET")
    public ResponseEntity<AdminLoginResponse> login(@RequestParam Map<String,String> map) {
        AdminLoginResponse adminLoginResponse = new AdminLoginResponse();
        LoginUser loginUser = isLoginSucess(map);
        if (loginUser != null) {
            adminLoginResponse.setCode(20000);
            adminLoginResponse.setToken(TOKEN); // 以后根据用户生成token
            adminLoginResponse.setAppId(loginUser.getAppId());
            log.info("User {} login successful", map.get("username"));
        } else {
            adminLoginResponse.setCode(60204);
            adminLoginResponse.setMessage("用户名或者密码不正确");
        }
        return ResponseEntity.ok(adminLoginResponse);
    }

    /**
     * login
     * @param map
     * @return
     */
    public LoginUser isLoginSucess(Map<String,String> map) {
        String username = map.get("username");
        String password = map.get("password");

        for (String key : LoginConstant.ROLE_ADMIN.keySet()) {
            LoginUser loginUser = LoginConstant.ROLE_ADMIN.get(key);
            if (key.equalsIgnoreCase(username) && loginUser.getPassword().equals(password)) {
                return loginUser;
            }
        }
        return null;
    }

    @GetMapping("/user/info/{token}")
    @ApiOperation(value = "userInfo", notes = "login user", httpMethod = "GET")
    public ResponseEntity<AdminUserResponse> getUserInfo(@PathVariable String token) {
        AdminUserResponse adminUserResponse = new AdminUserResponse();
        if (TOKEN.equals(token)) {
            String[] roles = new String[]{"admin"};
            adminUserResponse.setRoles(roles);
            adminUserResponse.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            adminUserResponse.setIntroduction("I am a super administrator");
            adminUserResponse.setName("Super Admin");
            adminUserResponse.setCode(20000);
        } else {
            adminUserResponse.setCode(401);
            adminUserResponse.setMessage("Token失效");
        }
        return ResponseEntity.ok(adminUserResponse);
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "logout", notes = "logout user", httpMethod = "GET")
    public ResponseEntity<AdminUserResponse> logout() {
        AdminUserResponse adminUserResponse = new AdminUserResponse();
        adminUserResponse.setCode(20000);
        return ResponseEntity.ok(adminUserResponse);
    }

}
