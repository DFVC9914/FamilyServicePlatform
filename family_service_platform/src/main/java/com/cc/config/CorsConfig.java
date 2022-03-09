package com.cc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 18:17
 * @Description: com.cc.config
 * @Version: 1.0
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration bulidConfig(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        //跨域是否为同一个session
        configuration.setAllowCredentials(true);
        return configuration;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",bulidConfig());
        return new CorsFilter(source);
    }
}
