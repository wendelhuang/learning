package com.sosimplebox.mall_001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(apiInfo())
						.select()
						.apis(RequestHandlerSelectors.basePackage("com.sosimplebox.mall_001.controller"))
						.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
						.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
						.paths(PathSelectors.any())
						.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SwaggerUI演示")
									.description("mall-tiny")
									.contact("macro")
									.version("1.0")
									.build();
	}
}
