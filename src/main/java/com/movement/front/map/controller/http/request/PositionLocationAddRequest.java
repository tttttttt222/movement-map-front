package com.movement.front.map.controller.http.request;

import java.math.BigDecimal;
import lombok.Data;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/2/4
 */
@Data
public class PositionLocationAddRequest {

	//
	private Long id;

	//地点名称
	private String positionName;

	//经度
	private BigDecimal lng;

	//纬度
	private BigDecimal lat;

	//地点类型:
	private Integer positionType;

	//是否显示 0 不显示 1 显示
	private Integer display;

	//地点地址
	private String positionAdress;

	//省
	private Integer provinces;

	//市
	private Integer cities;

	//区
	private Integer areas;

	//备注
	private String remark;



}
