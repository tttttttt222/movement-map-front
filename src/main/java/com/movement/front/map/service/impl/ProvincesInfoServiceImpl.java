package com.movement.front.map.service.impl;

import com.movement.front.map.controller.http.response.CitiesResponse;
import com.movement.front.map.controller.http.response.ProvincesResponse;
import com.movement.front.map.dao.mapper.CitiesDao;
import com.movement.front.map.dao.mapper.ProvincesDao;
import com.movement.front.map.dao.model.Cities;
import com.movement.front.map.dao.model.Provinces;
import com.movement.front.map.service.ProvincesInfoService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/3/1
 */
@Service
@Slf4j
public class ProvincesInfoServiceImpl implements ProvincesInfoService {

	@Autowired
	private ProvincesDao provincesDao;

	@Autowired
	private CitiesDao citiesDao;

	@Override
	public List<ProvincesResponse> queryProvincesAll() {
		List<ProvincesResponse> res = new ArrayList<>();
		List<Provinces> provinces = provincesDao.queryProvincesAll();
		for (Provinces province : provinces) {
			ProvincesResponse provincesResponse = new ProvincesResponse();
			BeanUtils.copyProperties(province, provincesResponse);
			res.add(provincesResponse);
		}
		return res;
	}


	@Override
	public List<CitiesResponse> queryCitiesByProvinceId(Integer provinceId) {
		List<CitiesResponse> res = new ArrayList<>();
		List<Cities> cities = citiesDao.queryCitiesByProvinceId(provinceId);
		for (Cities city : cities) {
			CitiesResponse citiesResponse = new CitiesResponse();
			BeanUtils.copyProperties(city, citiesResponse);
			res.add(citiesResponse);
		}
		return res;
	}


}
