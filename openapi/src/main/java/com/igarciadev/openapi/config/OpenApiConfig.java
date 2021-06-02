package com.igarciadev.openapi.config;

import org.springframework.beans.factory.annotation.Value;
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
public class OpenApiConfig
{
    @Value("${com.igarciadev.openapi.name}")
    private String appName;

    @Value("${com.igarciadev.openapi.version}")
    private String appVersion;

    @Value("${com.igarciadev.openapi.license.url}")
    private String appLicenseUrl;

    @Value("${com.igarciadev.openapi.terms.url}")
    private String appTermsUrl;

    @Value("${com.igarciadev.openapi.developer.name}")
    private String developerName;

    @Value("${com.igarciadev.openapi.developer.url}")
    private String developerUrl;

    @Bean
    public Docket customDocketConfig()
    {
        String basePackage = "com.igarciadev.openapi.controller";

        //@f:off
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());
        //@f:on
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title(appName)
                                   .description("Obtiene información sobre los recursos de la aplicación")
                                   .licenseUrl(appLicenseUrl)
                                   .termsOfServiceUrl(appTermsUrl)
                                   .version(appVersion)
                                   .contact(new Contact(developerName, developerUrl, ""))
                                   .build();
    }
}
