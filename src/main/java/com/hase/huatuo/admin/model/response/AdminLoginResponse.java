package com.hase.huatuo.admin.model.response;

import lombok.Data;

/**
 * <p> </p>
 * Created by shenpeng on  2020/2/6 15:36
 */
@Data
public class AdminLoginResponse extends AdminResponse {
    private String token;
    private String appId;
}
