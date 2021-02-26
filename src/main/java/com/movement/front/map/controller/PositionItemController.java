package com.movement.front.map.controller;

import com.movement.front.map.controller.http.request.PositionItemAddInfo;
import com.movement.front.map.controller.http.request.PositionLocationAddRequest;
import com.movement.front.map.controller.http.response.PositionItemInfoResponse;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import com.movement.front.map.controller.http.response.base.HttpResponse;
import com.movement.front.map.controller.http.response.base.Meta;
import com.movement.front.map.service.PositionItemService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/15
 */
@RestController
@RequestMapping("movement/front/item")
@Slf4j
public class PositionItemController {

	@Autowired
	private PositionItemService positionItemService;

	@PostMapping("/queryByLid/{lid}")
	@ResponseBody
	public HttpResponse<List<PositionItemInfoResponse>> queryByLid(HttpServletRequest request,
			@PathVariable long lid) {
		HttpResponse<List<PositionItemInfoResponse>> httpResponse = new HttpResponse<>(new Meta());

		List<PositionItemInfoResponse> itemInfoResponses = positionItemService.queryByLid(lid);

		httpResponse.setData(itemInfoResponses);
		httpResponse.getMeta().setMsg("");
		httpResponse.getMeta().setStatus(1);
		return httpResponse;
	}


	@PostMapping("/addItem")
	@ResponseBody
	public HttpResponse addItem(HttpServletRequest request, @RequestBody PositionItemAddInfo addRequest) {
		HttpResponse httpResponse = new HttpResponse(new Meta());
		if (addRequest.getDisplay() == null) {
			addRequest.setDisplay(1);
		}
		Integer res = positionItemService.insertItem(addRequest);

		if (res == null || res <= 0) {
			httpResponse.getMeta().setMsg("创建项目失败");
			httpResponse.getMeta().setStatus(2);
			return httpResponse;
		}

		httpResponse.getMeta().setMsg("创建项目成功");
		httpResponse.getMeta().setStatus(1);
		return httpResponse;
	}

}

