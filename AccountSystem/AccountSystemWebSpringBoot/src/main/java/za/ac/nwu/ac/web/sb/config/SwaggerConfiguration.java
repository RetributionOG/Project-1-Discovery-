package za.ac.nwu.ac.web.sb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Value("${swagger.application.version}")
    private String applicationVersion = "V1.8";

    @Value("${swagger.application.name}")
    private String applicationName = "Account System";

    @Value("${swagger.application.description}")
    private String applicationDescription = "Add, view or subtract Miles (or whatever currency people are using) to a members account";

    @Bean
    public Docket api() {
        return new Docket (DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                applicationName,
                applicationDescription,
                applicationVersion,
                "",
                new Contact("Kyle Cameron de Bastos", "", "cameronkdb@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
