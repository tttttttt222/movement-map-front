package com.movement.front.map.controller.http.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/2/4
 */
@Data
public class PositionItemInfoResponse {

	//
	private Long id;

	//项目名称
	private String itemName;

	//地点信息id
	private Integer locationId;

	//地点类型:
	private Integer positionType;

	//项目类型:
	private Integer itemType;

	//是否显示 0 不显示 1 显示
	private Integer display;

	//难度评分: 0-5
	private BigDecimal itemScore;

	//简介
	private String itemBrief;

	//视频地址
	private String itemVideoUrl;

	//视频封面地址
	private String itemVideoImgUrl;


	private String itemAdress;

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
