package com.movement.front.map.dao.mapper;


import com.movement.front.map.dao.dto.PositionLocationQueryDto;
import com.movement.front.map.dao.model.PositionLocationInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称:demo 描述: 创建人:ryw 创建时间:2018/12/25
 */
public interface PositionLocationInfoDao {

	List<PositionLocationInfo> queryPositionLocationInfoNear(@Param("info") PositionLocationQueryDto positionLocationQueryDto);

	void updatePositionLocationInfo(@Param("info") PositionLocationInfo positionLocationInfo);

	void insertPositionLocationInfo(@Param("info") PositionLocationInfo positionLocationInfo);


}
