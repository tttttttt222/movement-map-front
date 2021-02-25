package com.movement.front.map.controller;


import com.movement.front.map.controller.http.request.UserInfoRequest;
import com.movement.front.map.controller.http.response.UserInfoResponse;
import com.movement.front.map.controller.http.response.base.HttpResponse;
import com.movement.front.map.controller.http.response.base.Meta;
import com.movement.front.map.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 项目名称:com.examples.demo.mapper 描述: 创建人:ryw 创建时间:2018/5/23
 */
@RestController
@RequestMapping("movement/front/")
@Slf4j
public class LoginController {

	@Autowired
	private LoginService loginService;


	@PostMapping("login")
	@ResponseBody
	public HttpResponse<UserInfoResponse> login(HttpServletRequest request,
			@RequestBody UserInfoRequest userInfoRequest) {
		HttpResponse<UserInfoResponse> httpResponse = new HttpResponse<>(new Meta());

		try {
			UserInfoResponse userInfoResponse = loginService.queryUserInfo(userInfoRequest);
			if (userInfoResponse == null || !userInfoResponse.getPassword().equals(userInfoRequest.getPassword())) {
				httpResponse.getMeta().setMsg("登录失败");
				httpResponse.getMeta().setStatus(2);
				return httpResponse;
			}
			httpResponse.setData(userInfoResponse);
			httpResponse.getMeta().setMsg("登录成功");
			httpResponse.getMeta().setStatus(1);
		} catch (Exception e) {
			log.error(e.getMessage());
			httpResponse.getMeta().setMsg("登录失败");
			httpResponse.getMeta().setStatus(2);
		}
		return httpResponse;
	}


}
