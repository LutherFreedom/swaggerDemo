package com.luther.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Author: lvpeng
 * CreateTime: 2018/12/11 16:48
 * ProjectName: demo
 * PackageName: com.luther.demo.swagger
 * TODO:
 */
@Configuration
public class Swagger {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.luther.demo";
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))//api接口包扫描路径
                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger接口文档Demo")//设置文档的标题
                .description("简单优雅的restfun风格")//设置文档的描述->1.Overview
                .version(VERSION)//设置文档的版本信息-> 1.1 Version information
                .contact(new Contact("ABC Boot", "http://www.abc.comt", ""))//设置文档的联系方式->1.2 Contact information
                .termsOfServiceUrl("www.abc.com")//设置文档的License信息->1.3 License information
                .build();
    }
}