package com.movement.front.map.service;

import com.movement.front.map.controller.http.request.PositionLocationQueryRequest;
import com.movement.front.map.controller.http.response.PositionLocationInfoResponse;
import java.util.List;

/**
 * 项目名称:vue-shop-manager
 * 描述:
 * 创建人:ryw
 * 创建时间:2020/2/14
 */
public interface PositionLocationService {

    List<PositionLocationInfoResponse> queryLocationsNear(PositionLocationQueryRequest queryRequest);


}
