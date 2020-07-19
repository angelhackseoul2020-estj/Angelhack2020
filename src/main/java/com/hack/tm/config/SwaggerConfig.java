package com.hack.tm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("angelhack20")
                .description("API EXAMPLE")
                .build();
    }

    @Bean
    public Docket authApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("auth")
                .apiInfo(this.apiInfo())
                .produces(new HashSet<>(
                        Collections.singletonList("application/json")))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hack.tm.controller"))
                .paths(PathSelectors.ant("/auth/**"))
                .build();
    }

    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("auth")
            .apiInfo(this.apiInfo())
            .produces(new HashSet<>(
                Collections.singletonList("application/json")))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.hack.tm.controller"))
            .paths(PathSelectors.ant("/deal/**"))
            .build();
    }


    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("users")
                .apiInfo(this.apiInfo())
                .produces(new HashSet<>(
                        Collections.singletonList("application/json")))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hack.tm.controller"))
                .paths(PathSelectors.ant("/users/**"))
                .build();
    }




//
//    @Bean
//    public Docket userApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("users")
//                .apiInfo(this.apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.hack.tm.controller"))
//                .paths(PathSelectors.ant("/users/**"))
//                .build();
//    }
//
//    @Bean
//    public Docket mainApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("main")
//                .apiInfo(this.apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.hack.tm.controller"))
//                .paths(PathSelectors.ant("/**"))
//                .build();
//    }
//
//    @Bean
//    public Docket commonApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("waggerTest")
//                .apiInfo(this.apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors
//                .basePackage("com.hack.tm.controller"))
//                .paths(PathSelectors.ant("/api/**"))
//                .build();
//    }
}
