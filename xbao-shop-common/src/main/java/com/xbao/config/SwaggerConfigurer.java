package com.xbao.config;

import com.xbao.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:Swagger2 配置文件
 * @time 2018/4/20 22:42
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(Constants.BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(operationParameters()).pathMapping("/");// base，最终调用接口后会和paths拼接在一起
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口")
                .description("https://dev.tustore.api.oldace.cn/scmapi/swagger-ui.html")
                .termsOfServiceUrl("http://192.168.0.109:8080")
                .contact(new Contact("https://dev.tustore.api.oldace.cn/scmapi/", "swagger-ui.html", null))
                .version("2.0")
                .build();
    }

    public List<Parameter> operationParameters(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}
