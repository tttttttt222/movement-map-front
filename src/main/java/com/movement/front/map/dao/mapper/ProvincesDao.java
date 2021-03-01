package com.movement.front.map.dao.mapper;


import com.movement.front.map.dao.model.Provinces;
import java.util.List;

/**
 * 项目名称:demo 描述: 创建人:ryw 创建时间:2018/12/25
 */
public interface ProvincesDao {

	Provinces queryProvincesByProvinceId(Integer provinceId);

	List<Provinces> queryProvincesAll();
}
