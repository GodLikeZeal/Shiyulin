package com.zeal.shiyulin.common.config;

/**
 * Created by Zeal on 2017/12/5.
 */


import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Swagger配置类
 *
 * @auther Zeal
 * @create 2017/12/5
 **/
@Configuration
@EnableWebMvc
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?");
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "RESTful API接口管理",
                "所有后台服务对照表，包含请求类型，请求参数，字段描述以及解析，注意：前后台请仔细对照api，严格按照RESTful风格api要求",
                "www.kownyou.com",
                "zhangleifor@163.com",
                "MIT许可证",
                "My Apps API License URL");
        return apiInfo;
    }
}

