
// package com.idb.fruits.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// @Configuration
// public class WebConfig extends WebMvcConfigurationSupport {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOriginPatterns("*")
//                 .allowedMethods("*")
//                 .allowedHeaders("*");
//     }

// }



package com.idb.fruits.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
