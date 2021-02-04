package com.movement.front.map.service.impl;

import com.movement.front.map.common.Constant;
import com.movement.front.map.controller.http.request.PositionLocationQueryRequest;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import com.movement.front.map.dao.dto.PositionLocationQueryDto;
import com.movement.front.map.dao.mapper.PositionLocationInfoDao;
import com.movement.front.map.dao.model.PositionLocationInfo;
import com.movement.front.map.service.PositionLocationService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/14
 */
@Service
@Slf4j
public class PositionLocationServiceImpl implements PositionLocationService {

	@Autowired
	private PositionLocationInfoDao positionLocationInfoDao;

	@Override
	public List<PositionLocationInfoResponse> queryLocationsNear(PositionLocationQueryRequest queryRequest) {
		List<PositionLocationInfoResponse> res = new ArrayList<>();

		PositionLocationQueryDto positionLocationQueryDto = new PositionLocationQueryDto(Constant.radius,
				queryRequest.getLng(), queryRequest.getLat());
		List<PositionLocationInfo> positionLocationInfos = positionLocationInfoDao
				.queryPositionLocationInfoNear(positionLocationQueryDto);

		for (PositionLocationInfo positionLocationInfo : positionLocationInfos) {
			PositionLocationInfoResponse positionLocationInfoResponse = new PositionLocationInfoResponse();
			BeanUtils.copyProperties(positionLocationInfo, positionLocationInfoResponse);
			res.add(positionLocationInfoResponse);
		}

		return res;
	}


}
