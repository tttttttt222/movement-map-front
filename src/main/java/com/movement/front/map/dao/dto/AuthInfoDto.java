package com.movement.front.map.dao.dto;

import com.movement.front.map.dao.model.MenuInfo;
import com.movement.front.map.dao.model.UserInfo;
import java.util.List;
import lombok.Data;

/**
 * 项目名称:vue-shop-manager
 * 描述:
 * 创建人:ryw
 * 创建时间:2020/2/16
 */
@Data
public class AuthInfoDto {

    private UserInfo userInfo;

    private List<MenuInfo> menuInfos;

    private String errMsg;

    private boolean notAuth = false;

}
