package com.movement.front.map.service.impl;

import com.movement.front.map.controller.http.request.UserInfoRequest;
import com.movement.front.map.controller.http.response.MenuInfoResponse;
import com.movement.front.map.controller.http.response.UserInfoResponse;
import com.movement.front.map.dao.dto.AuthInfoDto;
import com.movement.front.map.dao.mapper.MenuInfoDao;
import com.movement.front.map.dao.mapper.UserInfoDao;
import com.movement.front.map.dao.model.MenuInfo;
import com.movement.front.map.dao.model.UserInfo;
import com.movement.front.map.service.LoginService;
import com.movement.front.map.service.RightsService;
import com.movement.front.map.service.RoleService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/14
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private Map<String, AuthInfoDto> redisCache;

	@Autowired
	private MenuInfoDao menuInfoDao;

	@Override
	public UserInfoResponse queryUserInfo(UserInfoRequest userInfoRequest) {
		UserInfo userInfo = userInfoDao.queryUserInfo(userInfoRequest.getUsername());
		if (userInfo == null) {
			return null;
		}
		List<MenuInfo> menuInfos = menuInfoDao.queryMenuInfoByRoleId(userInfo.getRid());

		UserInfoResponse userInfoResponse = new UserInfoResponse();
		BeanUtils.copyProperties(userInfo, userInfoResponse);

		String token = UUID.randomUUID().toString().replace("-", "");
		userInfoResponse.setToken(token);
		AuthInfoDto authInfoDto = new AuthInfoDto();
		authInfoDto.setUserInfo(userInfo);
		authInfoDto.setMenuInfos(menuInfos);

		redisCache.put(token, authInfoDto);
		return userInfoResponse;
	}
}
