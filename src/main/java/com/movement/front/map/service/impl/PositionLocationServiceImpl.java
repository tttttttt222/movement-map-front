package com.movement.front.map.service.impl;

import com.movement.front.map.common.Constant;
import com.movement.front.map.controller.http.request.PositionLocationAddRequest;
import com.movement.front.map.controller.http.request.PositionLocationQueryRequest;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import com.movement.front.map.dao.dto.PositionLocationQueryDto;
import com.movement.front.map.dao.mapper.PositionItemInfoDao;
import com.movement.front.map.dao.mapper.PositionLocationInfoDao;
import com.movement.front.map.dao.model.PositionItemInfo;
import com.movement.front.map.dao.model.PositionLocationInfo;
import com.movement.front.map.service.PositionLocationService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/2/14
 */
@Service
@Slf4j
public class PositionLocationServiceImpl implements PositionLocationService {

	@Autowired
	private PositionLocationInfoDao positionLocationInfoDao;

	@Autowired
	private PositionItemInfoDao positionItemInfoDao;

	@Autowired
	private TransactionTemplate transactionTemplate;

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
			positionLocationInfoResponse
					.setItemCount(
							String.valueOf(positionItemInfoDao.positionItemCountByLid(positionLocationInfo.getId())));
			res.add(positionLocationInfoResponse);
		}

		return res;
	}


	@Override
	public Integer insertLocation(PositionLocationAddRequest addRequest) {
		try {
			transactionTemplate.execute((TransactionCallback) transactionStatus -> {
				PositionLocationInfo positionLocationInfo = new PositionLocationInfo();
				BeanUtils.copyProperties(addRequest, positionLocationInfo);
				positionLocationInfoDao.insertPositionLocationInfo(positionLocationInfo);
				return null;
			});
		} catch (Exception e) {
			log.error("添加地点失败", e.getMessage());
			return null;
		}
		return 1;
	}


}
