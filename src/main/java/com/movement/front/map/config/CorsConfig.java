package com.movement.front.map.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目名称:demo 描述: 创建人:ryw 创建时间:2019/1/15
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

//	private CorsConfiguration buildConfig() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
//		corsConfiguration.addAllowedHeader("*"); // 2允许任何头
//		corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
//		return corsConfiguration;
//	}
//
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", buildConfig()); // 4
//		return new CorsFilter(source);
//	}

	public void addCorsMappings(CorsRegistry registry) {
		//设置允许跨域的路径
		registry.addMapping("/**")
				//设置允许跨域请求的域名
				.allowedOrigins("*")
				//这里：是否允许证书 不再默认开启
				.allowCredentials(true)
				//设置允许的方法
				.allowedMethods("*")
				//跨域允许时间
				.maxAge(3600);
	}
}
