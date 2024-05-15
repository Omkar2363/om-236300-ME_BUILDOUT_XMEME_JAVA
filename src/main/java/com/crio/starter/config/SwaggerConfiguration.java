// package com.crio.starter.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import springfox.documentation.PathProvider;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;


// @Configuration
// @EnableSwagger2
// @EnableWebMvc
// public class SwaggerConfiguration {

//     @Bean
//     public Docket myApi() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .apiInfo(getInfo())
//                 .select()
//                 .apis(RequestHandlerSelectors.any())
//                 .paths(PathSelectors.any())
//                 .build();
               
//     }

//     private ApiInfo getInfo(){

//         // return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions) new springfox.documentation.service.Contact(name, url, email)
//         // return new ApiInfo("XMeme Application APIs", "XMeme is a platform for the users to share the memes they created.", "1.0", "Terms of Service Url", new Contact("Omkar Yadav", "https://www.crio.do/", "https://www.gmail.com", "Licence of APIs", "http://localhost:8081/memes/", Collections.emptyList()));
    
//         return new ApiInfoBuilder().title("XMeme Application APIs").build();
//     }


    
// }


package com.crio.starter.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("XMeme Application APIs")
                        .description("XMeme is a platform for the users to share the memes they created.")
                        .version("1.0"));


    }
}