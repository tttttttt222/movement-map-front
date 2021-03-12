package com.movement.front.map.controller.http.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 项目名称:movement-map-front 描述: 创建人:ryw 创建时间:2021/3/1
 */
@Data
public class CitiesResponse {


	//主键
	private Integer id;

	//城市编码
	private Integer cityId;

	//城市名称
	private String city;

	//所属省份编码
	private Integer provinceId;

	//经度
	private BigDecimal lng;

	//纬度
	private BigDecimal lat;

	//
	private Date createTime;

	//
	private Date updateTime;
}
