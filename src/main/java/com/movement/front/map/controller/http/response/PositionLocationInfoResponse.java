package com.movement.front.map.controller.http.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/2/4
 */
@Data
public class PositionLocationInfoResponse {

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

	//预留字段1
	private String rem1;

	//预留字段2
	private String rem2;

	//预留字段3
	private String rem3;

	//
	private Date createTime;

	//
	private Date updateTime;


}
