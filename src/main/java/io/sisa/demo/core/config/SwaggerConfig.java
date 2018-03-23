package io.sisa.demo.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created on Mart, 2018
 *
 * @author isao
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()                 .apis(RequestHandlerSelectors.basePackage("io.sisa.demo.api.v1.controller"))
				.paths(regex("/v1/city.*"))
				.build()
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Demo REST API",
				"Demo Project",
				"1.0",
				"/",
				new Contact("Isa Ozturk", "https://sisa.github.io/aboutme/", "isaozturk@gmail.com"),
				"License",
				"/",
				Collections.emptyList());
		return apiInfo;
	}
}