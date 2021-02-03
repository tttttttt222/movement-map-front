package com.movement.front.map.service;

import com.movement.front.map.controller.http.request.RoleInfoRequest;
import com.movement.front.map.controller.http.response.MenuInfoResponse;
import com.movement.front.map.controller.http.response.RoleInfoResponse;
import com.movement.front.map.controller.http.response.RoleInfoWithRightsResponse;
import java.util.List;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/17
 */
public interface RoleService {

	List<RoleInfoWithRightsResponse> queryAllRoles();

	RoleInfoResponse insertRole(RoleInfoRequest roleInfoRequest);

	RoleInfoResponse queryRoleInfoById(Long id);

	RoleInfoResponse updateRoleInfoById(RoleInfoRequest roleInfoRequest);

	RoleInfoResponse deleteRoleById(Long id);

	RoleInfoResponse roleAddRights(Long roleId,List<Long> rids);

	List<MenuInfoResponse> roleDeleteRights(Long roleId, Long rightId);
}
