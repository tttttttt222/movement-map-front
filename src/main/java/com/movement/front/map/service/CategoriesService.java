package com.movement.front.map.service;

import com.movement.front.map.controller.http.request.CategoriesInfoQueryRequest;
import com.movement.front.map.controller.http.request.CategoriesInfoRequest;
import com.movement.front.map.controller.http.request.base.PageRequest;
import com.movement.front.map.controller.http.response.CategoriesInfoQueryResponse;
import com.movement.front.map.controller.http.response.CategoriesInfoResponse;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/3/3
 */
public interface CategoriesService {


	CategoriesInfoQueryResponse queryCategoriesPage(PageRequest<CategoriesInfoQueryRequest> pageRequest);

	CategoriesInfoResponse insertCategories(CategoriesInfoRequest categoriesInfoRequest);

	CategoriesInfoResponse queryCategoriesInfoById(Long id);

	CategoriesInfoResponse deleteCategoriesById(Long id);

	CategoriesInfoResponse updateCategoriesInfoById(CategoriesInfoRequest CategoriesInfoRequest);
}
