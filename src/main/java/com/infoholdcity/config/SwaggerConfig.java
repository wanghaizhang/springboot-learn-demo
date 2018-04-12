package com.infoholdcity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a9429
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.infoholdcity.demo.controller")
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        ComponentScan scan = SwaggerConfig.class.getDeclaredAnnotation(ComponentScan.class);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(scan.value()[0]))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("INFOHOLDCITY",
                "http://www.infoholdcity.cn",
                "infoholdcity@163.com");
        return new ApiInfoBuilder()
                .title("API Doc")
                .description("THIS IS PARTSELECTION DOCUMENT")
                .version("1.0.0")
                .build();
    }

}