package com.movement.front.map.controller.http.response.base;

import lombok.Data;

/**
 * 项目名称:vue-shop-manager
 * 描述:
 * 创建人:ryw
 * 创建时间:2020/2/14
 */
@Data
public class Meta {

    private String msg;
    //1成功 2 失败
    private Integer status;
}
