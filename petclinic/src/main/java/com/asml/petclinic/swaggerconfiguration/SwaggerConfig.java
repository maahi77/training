package com.asml.petclinic.swaggerconfiguration;



/* 
 * @author mahendra
 * 
*/
import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	    
	   @Bean
	   public Docket productApi() {
		      return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com.asml.petclinic")).paths(PathSelectors.any()).build().apiInfo(metaData());
		   }
	   private ApiInfo metaData() {
		   
		   return new ApiInfoBuilder().title("petclinic-springboot swagger configuration").description("\"pet application\"")
				   .version("1.1.0").contact(new Contact("pet application", "www.petapplication.com", "petapplication@gmail.com")).build();
		   
		   
	   }
}


