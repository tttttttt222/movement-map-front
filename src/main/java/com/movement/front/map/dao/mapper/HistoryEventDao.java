package com.movement.front.map.dao.mapper;

import com.movement.front.map.controller.http.request.HistoryEventInfoRequest;
import com.movement.front.map.dao.model.HistoryBriefEventInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/3/11
 */
public interface HistoryEventDao {

	HistoryBriefEventInfo queryHistoryEventById(Long id);

	void insertHistoryEventInfo(@Param("historyEvent") HistoryEventInfoRequest historyEventInfoRequest);

	void deleteHistoryEventById(Long id);

	void updateHistoryEventInfo(@Param("historyEvent") HistoryEventInfoRequest historyEventInfoRequest);

}
