package com.movement.front.map.controller.http.response;

import com.movement.front.map.controller.http.response.base.PageResponse;
import com.movement.front.map.dao.model.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * 项目名称:vue-shop-manager
 * 描述:
 * 创建人:ryw
 * 创建时间:2020/2/14
 */
@Data
public class UserInfoQueryResponse extends PageResponse {

   private List<UserInfo> users;
}
