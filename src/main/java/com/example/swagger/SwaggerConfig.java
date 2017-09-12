package com.example.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Kavinda on 9/12/2017.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greenleaf-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> postPaths() {
//        return or(regex("/.*")); // you can give permission to access all rest endpoints through the swagger UI.
        return or(regex("/book.*"),
                regex("/property.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot Mysql Swagger example rest API")
                .description("Spring boot rest API")
//                .termsOfServiceUrl("")
                .contact(contact())
                //.license("")
                //.licenseUrl("")
                .version("1.0.0")
                .build();
    }

    public Contact contact() {
        return new Contact(" Supun Kavinda", "", "naskavinda@gmail.com");
    }
}
