package com.ajayaw.cloud.awsstorage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8080/storage/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private List<Parameter> globalParams = new ArrayList<Parameter>();
	
	Contact contact = new Contact("Ajay Awasthi",
			"http://www.localhost:8080",
			"ajayawasthimca@gmail.com");
	
	ApiInfo apiInfo = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "http://localhost:8080/storage",
			contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
			
	@Bean
    public Docket api() {
		//configureCommonParam();
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().globalOperationParameters(globalParams);                                       
    }
	
	/*private void configureCommonParam() {
		ParameterBuilder aParameterBuilder = new ParameterBuilder();		
		globalParams.clear();
		aParameterBuilder.name("authorization").modelRef(new ModelRef("string")).parameterType("header").required(true)
				.build();
		globalParams.add(aParameterBuilder.build());
	}*/
}
