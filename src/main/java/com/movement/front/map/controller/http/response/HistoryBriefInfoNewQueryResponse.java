package com.movement.front.map.controller.http.response;

import com.movement.front.map.controller.http.response.base.PageResponse;
import com.movement.front.map.dao.model.HistoryBriefInfo;
import java.util.List;
import lombok.Data;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/4/22
 */
@Data
public class HistoryBriefInfoNewQueryResponse extends PageResponse {

	private List<HistoryBriefInfo> list;
}
