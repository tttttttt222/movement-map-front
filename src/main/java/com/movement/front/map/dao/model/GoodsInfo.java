package com.movement.front.map.dao.model;

import java.math.BigDecimal;
import lombok.Data;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/3/10
 */
@Data
public class GoodsInfo {

	//
	private Long id;

	//
	private String goodsName;

	//
	private BigDecimal goodsPrice;

	//
	private Integer goodsNumber;

	//
	private BigDecimal goodsWeight;

	//
	private Integer goodsState;

	//
	private Integer hotMumber;

	//
	private Integer isPromote;

	//
	private String goodsSmallLogo;

	//
	private String goodsBigLogo;

	//
	private String goodsIntroduce;

	//
	private Integer isDel;

	//
	private String createTime;

	//
	private String updateTime;

	//
	private String deleteTime;

}
