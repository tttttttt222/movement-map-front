package com.movement.front.map.controller;

import com.movement.front.map.controller.http.response.CitiesResponse;
import com.movement.front.map.controller.http.response.ProvincesResponse;
import com.movement.front.map.controller.http.response.base.HttpResponse;
import com.movement.front.map.controller.http.response.base.Meta;
import com.movement.front.map.service.ProvincesInfoService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/3/12
 */
@RestController
@RequestMapping("movement/front/provinces")
@Slf4j
public class ProvincesInfoController {

	@Autowired
	private ProvincesInfoService provincesInfoService;

	@PostMapping("/queryProvincesAll")
	@ResponseBody
	public HttpResponse<List<ProvincesResponse>> queryProvincesAll(HttpServletRequest request) {
		HttpResponse<List<ProvincesResponse>> httpResponse = new HttpResponse<>(new Meta());

		List<ProvincesResponse> provincesResponses = provincesInfoService.queryProvincesAll();

		httpResponse.setData(provincesResponses);
		httpResponse.getMeta().setMsg("");
		httpResponse.getMeta().setStatus(1);

		return httpResponse;
	}


	@PostMapping("/queryCityById/{cid}")
	@ResponseBody
	public HttpResponse<List<CitiesResponse>> queryCityById(HttpServletRequest request, @PathVariable int cid) {
		HttpResponse<List<CitiesResponse>> httpResponse = new HttpResponse<>(new Meta());

		List<CitiesResponse> citiesResponses = provincesInfoService.queryCitiesByProvinceId(cid);

		httpResponse.setData(citiesResponses);
		httpResponse.getMeta().setMsg("");
		httpResponse.getMeta().setStatus(1);

		return httpResponse;
	}

}
