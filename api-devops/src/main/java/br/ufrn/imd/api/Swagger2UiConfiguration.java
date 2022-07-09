package br.ufrn.imd.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration  
{
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .build()
        .apiInfo(apiInfo());
  }
  
  private ApiInfo apiInfo() {
	  return new ApiInfoBuilder().title("API DevOps").version("1.0.0").description("Api de referência aos endpoints DevOps").build();
  }
  
}