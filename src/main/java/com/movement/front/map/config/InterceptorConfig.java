package com.movement.front.map.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目名称:vue-shop-manager 描述: 创建人:ryw 创建时间:2020/3/2
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	AuthInterceptor authInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/movement/front/**")
				.excludePathPatterns("/movement/front/login")
				.excludePathPatterns("/movement/front/item/**")
				.excludePathPatterns("/movement/front/location/**")
				.excludePathPatterns("/movement/front/provinces/**");

	}


}
