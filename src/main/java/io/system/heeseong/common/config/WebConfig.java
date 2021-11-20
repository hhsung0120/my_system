package io.system.heeseong.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Value("${path.web-access-path}")
    String webAccessPath;

    @Value("${path.default-upload-path}")
    String fileUploadPath;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new TokenCheckInterceptor())
//				.excludePathPatterns("/docs/**")
//				.excludePathPatterns("/api/**")
//				.excludePathPatterns("/test/**")
//				.excludePathPatterns("/users/login")
//				.excludePathPatterns("/users/invalidToken")
//				.excludePathPatterns("/users/signUp")
//				.excludePathPatterns("/users/signUpDetail")
//				.addPathPatterns("/**")
//				;

    }
}