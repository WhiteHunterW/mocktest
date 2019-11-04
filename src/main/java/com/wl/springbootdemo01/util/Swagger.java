package com.wl.springbootdemo01.util;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化swagger配置类
 * @author w.z
 * @date 2019/10/28 17:03
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger implements WebMvcConfigurer {
    
    /**
     * 添加摘要信息
     * @return
     */
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wl.springbootdemo01.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes());
    }
    
    /**
     * 添加接口文档描述信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Springboot集合swagger测试接口文档")
                .description("包含管理区域信息,学生信息的增删改查模块")
                .version("1.0")
                .contact(new Contact("wz","https://blog.csdn.net/qq_43446343","2295206998@qq.com"))
                .build();
                
    }

    /**
     * SecurityScheme 子类 BasicAuth OAuth ApiKey
     * @return
     */
    private List<SecurityScheme> securitySchemes(){
        List<SecurityScheme> list = new ArrayList<>();
        // basicAuth SwaggerBootstrapUI支持的不好,使用swagger原生UI
        list.add(new BasicAuth("basicAuth"));
        return list;
    }
}
