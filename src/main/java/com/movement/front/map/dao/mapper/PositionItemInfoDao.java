package com.movement.front.map.dao.mapper;


import com.movement.front.map.dao.dto.PositionLocationQueryDto;
import com.movement.front.map.dao.model.PositionItemInfo;
import com.movement.front.map.dao.model.PositionLocationInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称:demo 描述: 创建人:ryw 创建时间:2018/12/25
 */
public interface PositionItemInfoDao {

	List<PositionItemInfo> queryPositionItemByLid(Long lid);

	void updatePositionItemInfo(@Param("info") PositionItemInfo info);

	void insertPositionItemInfo(@Param("info") PositionItemInfo info);


}
