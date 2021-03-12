package com.movement.front.map.service;

import com.movement.front.map.controller.http.response.CitiesResponse;
import com.movement.front.map.controller.http.response.ProvincesResponse;
import com.movement.front.map.dao.model.Provinces;
import java.util.List;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/3/1
 */

public interface ProvincesInfoService {


	List<ProvincesResponse> queryProvincesAll();

	List<CitiesResponse> queryCitiesByProvinceId(Integer provinceId);
}
