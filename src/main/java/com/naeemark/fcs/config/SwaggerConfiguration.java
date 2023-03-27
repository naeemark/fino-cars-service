package com.naeemark.fcs.config;

import com.google.common.base.Predicates;
import lombok.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@Generated
public class SwaggerConfiguration {

    public static final String HEALTH_TAG = "0 - Health Check";
    public static final String CARS_TAG = "1 - Cars";

    @Bean
    @Generated
    @SuppressWarnings("deprecation")
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(
                        "Fino Cars Service",
                        "REST API Specification for Fino Cars Service",
                        "v1.0.0",
                        "https://opensource.org/license/mit",
                        new Contact("Naeem", "https://www.github.com/naeemark/fino-cars-service", "naeemark@gmail.com").toString(),
                        "MIT",
                        "https://opensource.org/license/mit"
                ))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .tags(
                        new Tag(HEALTH_TAG, "Service health check"),
                        new Tag(CARS_TAG, "Operations related to Cars")
                );
    }

    @Bean
    @Generated
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
            }
        };
    }
}
