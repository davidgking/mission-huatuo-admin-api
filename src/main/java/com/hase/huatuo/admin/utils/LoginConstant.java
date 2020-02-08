package com.hase.huatuo.admin.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> </p>
 * Created by shenpeng on  2020/2/8 16:53
 */
public class LoginConstant {

    public static final Map<String,LoginUser> ROLE_ADMIN = new HashMap<>();

    static {
        ROLE_ADMIN.put("haseitadmin",
                new LoginUser("haseitadmin","111111","wx9812117be87d24d2"));
        ROLE_ADMIN.put("hacnadmin",
                new LoginUser("hacnadmin","111111","wxf60257610325b729"));
    }

}
