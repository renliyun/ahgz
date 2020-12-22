package com.vot.ahgz.config;

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



/**
 * Swagger2API文档的配置
 * Created on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    // swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.vot.ahgz.controller")).paths(PathSelectors.any())
                .build();
    }
    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("安徽光智科技有限公司（北京分公司）库存 API")
                // 创建人信息
                .contact(new Contact("RenLiRong",  "https://www.baidu.html",  "renliyun@live.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}