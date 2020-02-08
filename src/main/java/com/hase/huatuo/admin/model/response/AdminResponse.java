package com.hase.huatuo.admin.model.response;

import lombok.Data;

import java.util.List;

/**
 * <p> </p>
 * Created by shenpeng on  2020/2/6 17:32
 */
@Data
public class AdminResponse {
    private Integer code;

    private String message;

    private Integer total;

    private List<?> items;

}
