package com.movement.front.map.service.impl;

import com.movement.front.map.controller.http.request.RoleInfoRequest;
import com.movement.front.map.controller.http.response.MenuInfoResponse;
import com.movement.front.map.controller.http.response.RoleInfoResponse;
import com.movement.front.map.controller.http.response.RoleInfoWithRightsResponse;
import com.movement.front.map.controller.http.response.UserInfoResponse;
import com.movement.front.map.dao.mapper.RoleInfoDao;
import com.movement.front.map.dao.model.MenuInfo;
import com.movement.front.map.dao.model.RoleInfo;
import com.movement.front.map.service.RightsService;
import com.movement.front.map.service.RoleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/17
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RightsService rightsService;

	@Autowired
	private RoleInfoDao roleInfoDao;

	@Autowired
	private TransactionTemplate transactionTemplate;


	@Override
	public List<RoleInfoWithRightsResponse> queryAllRoles() {
		List<RoleInfo> roleInfos = roleInfoDao.queryRoleInfoAll();
		List<RoleInfoWithRightsResponse> roleInfoWithRightsResponses = new ArrayList<>();
		for (RoleInfo roleInfo : roleInfos) {
			RoleInfoWithRightsResponse roleInfoWithRightsResponse = new RoleInfoWithRightsResponse();
			BeanUtils.copyProperties(roleInfo, roleInfoWithRightsResponse);
			roleInfoWithRightsResponses.add(roleInfoWithRightsResponse);
			roleInfoWithRightsResponse.setChildren(rightsService.getAllRightsInfoTreeByRoleId(roleInfo.getId()));
		}
		return roleInfoWithRightsResponses;
	}

	@Override
	public RoleInfoResponse insertRole(RoleInfoRequest roleInfoRequest) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		try {
			roleInfoRequest.setStatus(1);
			roleInfoDao.insertRoleOne(roleInfoRequest);
		} catch (Exception e) {
			log.error("添加失败", e.getMessage());
			return null;
		}
		BeanUtils.copyProperties(roleInfoRequest, roleInfoResponse);
		return roleInfoResponse;
	}

	@Override
	public RoleInfoResponse queryRoleInfoById(Long id) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		RoleInfo roleInfo = roleInfoDao.queryRoleInfoById(id);
		BeanUtils.copyProperties(roleInfo, roleInfoResponse);
		return roleInfoResponse;
	}

	@Override
	public RoleInfoResponse updateRoleInfoById(RoleInfoRequest roleInfoRequest) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		try {
			roleInfoDao.updateRoleInfo(roleInfoRequest);
		} catch (Exception e) {
			log.error("更新失败", e.getMessage());
			return null;
		}
		BeanUtils.copyProperties(roleInfoRequest, roleInfoResponse);
		return roleInfoResponse;
	}

	@Override
	public RoleInfoResponse deleteRoleById(Long id) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		try {
			transactionTemplate.execute((TransactionCallback) transactionStatus -> {
				roleInfoDao.deleteRoleById(id);
				rightsService.deleteRightsByRId(id);
				return null;
			});
		} catch (Exception e) {
			log.error("删除失败", e.getMessage());
			return null;
		}
		return roleInfoResponse;
	}

	@Override
	public RoleInfoResponse roleAddRights(Long roleId, List<Long> rids) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		try {
			transactionTemplate.execute((TransactionCallback) transactionStatus -> {
				rightsService.deleteRightsByRId(roleId);
				rightsService.addRightsByRoleId(roleId, rids);
				return null;
			});
		} catch (Exception e) {
			log.error("添加失败", e.getMessage());
			return null;
		}
		return roleInfoResponse;
	}

	@Override
	public List<MenuInfoResponse> roleDeleteRights(Long roleId, Long rightId) {
		transactionTemplate.execute((TransactionCallback) transactionStatus -> {
			deleteRecursion(roleId, rightId);
			return null;
		});
		List<MenuInfoResponse> allRightsInfoTreeByRoleId = rightsService.getAllRightsInfoTreeByRoleId(roleId);
		return allRightsInfoTreeByRoleId;
	}


	private void deleteRecursion(Long roleId, Long rightId) {
		rightsService.roleDeleteRights(roleId, rightId);
		List<MenuInfo> menuInfos = rightsService.queryMenuInfoByPid(roleId, rightId);
		if (menuInfos != null && menuInfos.size() > 0) {
			for (MenuInfo menuInfo : menuInfos) {
				deleteRecursion(roleId, menuInfo.getId());
			}
		}
	}


}
