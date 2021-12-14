package io.system.heeseong.common.config;

import io.system.heeseong.common.interceptor.CheckLoginInterceptor;
import io.system.heeseong.common.interceptor.MenuPermissionCheckInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Value("${path.web-access-path}")
    String webAccessPath;

    @Value("${path.default-upload-path}")
    String fileUploadPath;

    List<String> resourcesList = Arrays.asList(
            "/css/**", "/fonts/**", "/js/**", "/smartEditor/**"
            , "/favicon.ico", "/test/**", "/users/login", "/error/**"
            , "/config/**");

    // 업로드 폴더 지정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(webAccessPath)
                .addResourceLocations("file:///"+fileUploadPath+"/")
                ;
    }
	
    // 인덱스 페이지 설정
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/users/login");
    }

    @Bean
    CheckLoginInterceptor checkLoginInterceptor(){
        return new CheckLoginInterceptor();
    }

    @Bean
    MenuPermissionCheckInterceptor menuPermissionCheckInterceptor(){
        return new MenuPermissionCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(checkLoginInterceptor())
                .excludePathPatterns(resourcesList)
                .addPathPatterns("/**")
		;

        registry.addInterceptor(menuPermissionCheckInterceptor())
                .excludePathPatterns(resourcesList)
                .addPathPatterns("/**")
        ;
    }
}