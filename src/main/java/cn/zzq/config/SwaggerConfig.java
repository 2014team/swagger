package cn.zzq.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

@EnableSwagger2
@ComponentScan(basePackages = {"cn.zzq.controller"})
@Configuration
public class SwaggerConfig implements  WebMvcConfigurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("《SwaggerDemo的演示案例--》")//标题
                .description("description:项目摘要")//描述
                .termsOfServiceUrl("http://www.google.com.hk")//（不可见）条款地址，公司内部使用的话不需要配
                .contact(new Contact("Devil", "http://www.google.com.hk", "645874679@qq.com"))//作者信息
                .version("2.9.2")//版本号
                .build();
    }
}
