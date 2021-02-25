package com.movement.front.map.service.impl;


import com.movement.front.map.controller.http.request.UserInfoRequest;
import com.movement.front.map.controller.http.response.UserInfoResponse;
import com.movement.front.map.dao.dto.AuthInfoDto;
import com.movement.front.map.dao.mapper.UserInfoDao;
import com.movement.front.map.dao.model.UserInfo;
import com.movement.front.map.service.LoginService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	@Override
	public UserInfoResponse queryUserInfo(UserInfoRequest userInfoRequest) {
		UserInfo userInfo = userInfoDao.queryUserInfo(userInfoRequest.getUsername());
		if (userInfo == null) {
			return null;
		}

		UserInfoResponse userInfoResponse = new UserInfoResponse();
		BeanUtils.copyProperties(userInfo, userInfoResponse);

		String token = UUID.randomUUID().toString().replace("-", "");
		userInfoResponse.setToken(token);
		AuthInfoDto authInfoDto = new AuthInfoDto();
		authInfoDto.setUserInfo(userInfo);

		redisCache.put(token, authInfoDto);
		return userInfoResponse;
	}
}
