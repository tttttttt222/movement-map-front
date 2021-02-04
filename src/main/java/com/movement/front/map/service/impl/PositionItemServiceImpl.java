package com.movement.front.map.service.impl;

import com.movement.front.map.common.Constant;
import com.movement.front.map.controller.http.request.PositionLocationQueryRequest;
import com.movement.front.map.controller.http.response.PositionItemInfoResponse;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import com.movement.front.map.dao.dto.PositionLocationQueryDto;
import com.movement.front.map.dao.mapper.PositionItemInfoDao;
import com.movement.front.map.dao.model.PositionItemInfo;
import com.movement.front.map.dao.model.PositionLocationInfo;
import com.movement.front.map.service.PositionItemService;
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
public class PositionItemServiceImpl implements PositionItemService {

	@Autowired
	private PositionItemInfoDao positionItemInfoDao;

	@Override
	public List<PositionItemInfoResponse> queryByLid(Long lid) {
		List<PositionItemInfoResponse> res = new ArrayList<>();

		List<PositionItemInfo> positionItemInfos = positionItemInfoDao.queryPositionItemByLid(lid);

		for (PositionItemInfo positionItemInfo : positionItemInfos) {
			PositionItemInfoResponse positionItemInfoResponse = new PositionItemInfoResponse();
			BeanUtils.copyProperties(positionItemInfo, positionItemInfoResponse);
			res.add(positionItemInfoResponse);
		}

		return res;
	}


}
