package com.movement.front.map.controller;

import com.movement.front.map.controller.http.request.PositionLocationAddRequest;
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
@RequestMapping("movement/front/location")
@Slf4j
public class PositionLocationController {

	@Autowired
	private PositionLocationService positionLocationService;

	@PostMapping("/queryNear")
	@ResponseBody
	public HttpResponse<List<PositionLocationInfoResponse>> queryLocationsNear(HttpServletRequest request, @RequestBody
			PositionLocationQueryRequest queryRequest) {
		HttpResponse<List<PositionLocationInfoResponse>> httpResponse = new HttpResponse<>(new Meta());

		List<PositionLocationInfoResponse> locationInfoResponses = positionLocationService
				.queryLocationsNear(queryRequest);

		httpResponse.setData(locationInfoResponses);
		httpResponse.getMeta().setMsg("");
		httpResponse.getMeta().setStatus(1);

		return httpResponse;
	}

	@PostMapping("/addLocation")
	@ResponseBody
	public HttpResponse addLocation(HttpServletRequest request, @RequestBody PositionLocationAddRequest addRequest) {
		HttpResponse httpResponse = new HttpResponse(new Meta());
		if (addRequest.getDisplay() == null) {
			addRequest.setDisplay(1);
		}
		Integer res = positionLocationService.insertLocation(addRequest);

		if (res == null || res <= 0) {
			httpResponse.getMeta().setMsg("创建地点失败");
			httpResponse.getMeta().setStatus(2);
			return httpResponse;
		}

		httpResponse.getMeta().setMsg("创建地点成功");
		httpResponse.getMeta().setStatus(1);
		return httpResponse;
	}


}

