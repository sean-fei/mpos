package com.mpos.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
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
public class Swagger2Config {

    @Bean
    public Docket userApi() {
        Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(newArrayList(new ApiKey[]{this.apiKey()}))
//               .securitySchemes(newArrayList(new BasicAuth("test"))) //账号密码登录
//               .enable(false)   //禁止使用
                .apiInfo(apiInfo())
                .select()
//               .apis(RequestHandlerSelectors.basePackage("com.wechat"))
                .apis(swaggerSelector)
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
//                .title("微信点餐系统")
                .description("平台 RESTful 风格的接口文档")
//                .license("Licens")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .contact(new Contact("sean","官网地址url","sean@qq.com"))
                .version("0.1.0")
                .build();
    }

//    ApiKey apiKey() {
//        return new ApiKey("sessionId", "sessionId", "header");
//    }

}
