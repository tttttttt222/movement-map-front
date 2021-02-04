package com.movement.front.map.controller;

import com.movement.front.map.controller.http.request.PositionLocationQueryRequest;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import com.movement.front.map.controller.http.response.base.HttpResponse;
import com.movement.front.map.controller.http.response.base.Meta;
import com.movement.front.map.service.PositionLocationService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/15
 */
@RestController
@RequestMapping("api/movement/front/")
@Slf4j
public class PositionLocationController {

	@Autowired
	private PositionLocationService positionLocationService;

	@PostMapping("location")
	@ResponseBody
	public HttpResponse<List<PositionLocationInfoResponse>> queryLocationsNear(HttpServletRequest request, @RequestBody
			PositionLocationQueryRequest queryRequest) {
		HttpResponse<List<PositionLocationInfoResponse>> httpResponse = new HttpResponse<>(new Meta());

		List<PositionLocationInfoResponse> userInfoPageResponse = positionLocationService.queryLocationsNear(queryRequest);

		httpResponse.setData(userInfoPageResponse);
		httpResponse.getMeta().setMsg("");
		httpResponse.getMeta().setStatus(1);
		return httpResponse;
	}






}

